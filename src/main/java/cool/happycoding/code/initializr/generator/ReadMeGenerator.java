package cool.happycoding.code.initializr.generator;

import static cool.happycoding.code.initializr.generator.GeneratorPath.GenerateFile.README_FILE;

/**
 * <p>SrcMainResGenerator.java</P>
 *
 * @author lanlanhappy
 * @date 2021/01/16 5:36 下午
 */
public class ReadMeGenerator implements Generator{

    private final GenerationConfiguration generationConfiguration;

    public ReadMeGenerator(GenerationConfiguration generationConfiguration){
        this.generationConfiguration = generationConfiguration;
    }

    @Override
    public void generator() {
        new BaseGenerator(generationConfiguration, README_FILE).generator();
    }
}
