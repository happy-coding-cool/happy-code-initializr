package cool.happycoding.code.initializr.generator.build;

import cool.happycoding.code.initializr.generator.GenerationConfig;
import cool.happycoding.code.initializr.generator.Generator;

/**
 * @ClassName GradleBuildGenerator
 * @Description Gradle配置生成
 * @Author lanlanhappy
 * @Date 2020/12/31 9:15 上午
 */
public class GradleBuildGenerator implements Generator {

    private final GenerationConfig generationConfig;

    public GradleBuildGenerator(GenerationConfig generationConfig) {
        this.generationConfig = generationConfig;
    }

    @Override
    public void generator() {

    }
}
