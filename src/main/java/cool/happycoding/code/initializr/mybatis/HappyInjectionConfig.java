package cool.happycoding.code.initializr.mybatis;

import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.google.common.collect.Lists;
import cool.happycoding.code.initializr.generator.GenerationConfiguration;

import java.util.List;

/**
 * <p>HappyInjectionConfig.java</P>
 *
 * @author lanlanhappy
 * @date 2021/03/12 2:42 下午
 */
public class HappyInjectionConfig extends InjectionConfig{

    private final GenerationConfiguration generationConfiguration;
    private final String outPath;

    public HappyInjectionConfig(GenerationConfiguration generationConfiguration){
        this.generationConfiguration = generationConfiguration;
        this.outPath = generationConfiguration.getZipFilePath();

    }
    @Override
    public void initMap() {
        this.setMap(generationConfiguration.buildGenerateParamMap());
    }

    private List<FileOutConfig> buildFileOutConfig(){

        List<FileOutConfig> fileOutConfigs = Lists.newArrayList();
        FileOutConfig addFormConfig = new FileOutConfig("/templates/addForm.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return outPath+"";
            }
        };
        FileOutConfig qryFormConfig = new FileOutConfig("/templates/qryForm.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return outPath+"";
            }
        };
        FileOutConfig qryPageFormConfig = new FileOutConfig("/templates/qryPageForm.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return outPath+"";
            }
        };
        FileOutConfig updateFormConfig = new FileOutConfig("/templates/updateForm.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return outPath+"";
            }
        };
        fileOutConfigs.add(addFormConfig);
        fileOutConfigs.add(qryFormConfig);
        fileOutConfigs.add(qryPageFormConfig);
        fileOutConfigs.add(updateFormConfig);
        return fileOutConfigs;
    }

    @Override
    public InjectionConfig setConfig(ConfigBuilder config) {
        super.setConfig(config);
        this.setFileOutConfigList(buildFileOutConfig());
        return this;
    }
}
