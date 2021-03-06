package cool.happycoding.code.initializr.generator.build;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.initializr.generator.BaseGenerator;
import cool.happycoding.code.initializr.generator.GenerationConfiguration;
import cool.happycoding.code.initializr.generator.Generator;

import static cool.happycoding.code.initializr.generator.GeneratorPath.GenerateFile.POM_FILE;

/**
 * @ClassName MavenBuildGenerator
 * @Description maven配置生成
 * @Author lanlanhappy
 * @Date 2020/12/31 9:14 上午
 */
public class MavenBuildGenerator implements Generator{

    private final GenerationConfiguration generationConfiguration;

    public MavenBuildGenerator(GenerationConfiguration generationConfiguration){
        this.generationConfiguration = generationConfiguration;
    }
    @Override
    public void generator() {
        // 复制 file目录下的文件到目标目录
        String mvnwPath = "/file/mvn/mvmw";
        String mvnwCmdPath = "/file/mvn/mvmw.cmd";
        String mvnWrapperPath = "file/mvn/wrapper";
        // 复制 mvnw mvn.cmd 文件
        FileUtil.copy(mvnwPath, generationConfiguration.getZipFilePath(), true);
        FileUtil.copy(mvnwCmdPath, generationConfiguration.getZipFilePath(), true);
        // 生成.mvn 文件夹 复制 wrapper文件的内容
        FileUtil.copy(mvnWrapperPath, StrUtil.concat(false, generationConfiguration.getZipFilePath(),"/.mvn/"), true);
        // 生成pom文件
        new BaseGenerator(generationConfiguration, POM_FILE).generator();
    }
}
