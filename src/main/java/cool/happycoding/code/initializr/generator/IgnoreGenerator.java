package cool.happycoding.code.initializr.generator;

import static cool.happycoding.code.initializr.generator.GeneratorPath.GenerateFile.IGNORE_FILE;

/**
 * <p>IgnoreGenerator.java</P>
 *
 * @author lanlanhappy
 * @date 2021/03/06 10:53 上午
 */
public class IgnoreGenerator implements Generator{

    private final GenerationConfig generationConfig;

    public IgnoreGenerator(GenerationConfig generationConfig){
        this.generationConfig = generationConfig;
    }

    @Override
    public void generator() {
        // 生成ignore
        new BaseGenerator(generationConfig, IGNORE_FILE).generator();
    }
}
