package cool.happycoding.code.initializr.generator;

import static cool.happycoding.code.initializr.generator.GeneratorPath.GenerateFile.IGNORE_FILE;

/**
 * <p>IgnoreGenerator.java</P>
 *
 * @author lanlanhappy
 * @date 2021/03/06 10:53 上午
 */
public class IgnoreGenerator implements Generator{

    private final GenerationConfiguration generationConfiguration;

    public IgnoreGenerator(GenerationConfiguration generationConfiguration){
        this.generationConfiguration = generationConfiguration;
    }

    @Override
    public void generator() {
        // 生成ignore
        new BaseGenerator(generationConfiguration, IGNORE_FILE).generator();
    }
}
