package cool.happycoding.code.initializr.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import cool.happycoding.code.initializr.dto.form.Author;
import cool.happycoding.code.initializr.dto.form.Database;
import cool.happycoding.code.initializr.dto.form.HappyCodeForm;
import cool.happycoding.code.initializr.dto.form.ProjectMetadata;

/**
 * <p>MybatisGenerator.java</P>
 *
 * @author lanlanhappy
 * @date 2021/03/08 9:25 下午
 */
public class MybatisGenerator implements Generator{

    private final AutoGenerator autoGenerator;
    /**
     * 是否覆盖原来已有的文件
     */
    private static final Boolean IS_FILE_OVERRIDE = true;

    public MybatisGenerator(GenerationConfiguration generationConfiguration){
        this.autoGenerator = build(generationConfiguration);
    }

    private AutoGenerator build(GenerationConfiguration generationConfiguration) {
        HappyCodeForm happyCodeForm = generationConfiguration.getHappyCodeForm();
        Database database = happyCodeForm.getDatabase();
        Author author = happyCodeForm.getAuthor();
        ProjectMetadata projectMetadata = happyCodeForm.getProjectMetadata();
        return new AutoGenerator()
                // 全局配置
                .setGlobalConfig(globalConfig(author, generationConfiguration.getZipFilePath()))
                // 数据库配置
                .setDataSource(dataSourceConfig(database))
                // 包配置
                .setPackageInfo(packageConfig(projectMetadata))
                // 自定义配置
                .setCfg(generationConfiguration.injectionConfig());
    }

    private GlobalConfig globalConfig(Author author, String outDir){
        // 全局配置
        return new GlobalConfig()
                .setOutputDir(outDir + "/src/main/java")
                .setAuthor(author.getName())
                .setOpen(false)
                .setFileOverride(IS_FILE_OVERRIDE)
                // 实体属性 Swagger2 注解
                .setSwagger2(true)
                .setDateType(DateType.ONLY_DATE)
                .setBaseColumnList(true)
                .setBaseResultMap(true);
    }

    private DataSourceConfig dataSourceConfig(Database database){
        return new DataSourceConfig()
                        .setUrl(database.mysqlConn())
                        .setDriverName(Config.MYSQL_DRIVER)
                        .setUsername(database.getUsername())
                        .setPassword(database.getPassword());
    }

    private PackageConfig packageConfig(ProjectMetadata projectMetadata){

        return new PackageConfig()
                        .setParent(projectMetadata.getProPackage())
                        .setController("rest")
                        .setService("service")
                        .setServiceImpl("service.impl")
                        .setEntity("dao.entity")
                        .setMapper("dao.mapper")
                        .setXml("");
    }


    @Override
    public void generator() {
        autoGenerator.execute();
    }
}
