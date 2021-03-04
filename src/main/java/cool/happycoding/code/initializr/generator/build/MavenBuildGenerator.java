package cool.happycoding.code.initializr.generator.build;

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
        new BaseGenerator(generationConfiguration, POM_FILE).generator();
    }
}
