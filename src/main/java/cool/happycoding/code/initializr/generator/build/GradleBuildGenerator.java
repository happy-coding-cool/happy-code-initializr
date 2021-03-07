package cool.happycoding.code.initializr.generator.build;

import cool.happycoding.code.initializr.generator.GenerationConfiguration;
import cool.happycoding.code.initializr.generator.Generator;

/**
 * @ClassName GradleBuildGenerator
 * @Description Gradle配置生成
 * @Author lanlanhappy
 * @Date 2020/12/31 9:15 上午
 */
public class GradleBuildGenerator implements Generator {

    private final GenerationConfiguration generationConfiguration;

    public GradleBuildGenerator(GenerationConfiguration generationConfiguration) {
        this.generationConfiguration = generationConfiguration;
    }

    @Override
    public void generator() {

    }
}
