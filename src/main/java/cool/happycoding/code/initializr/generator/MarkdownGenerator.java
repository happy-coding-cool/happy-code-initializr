package cool.happycoding.code.initializr.generator;

import static cool.happycoding.code.initializr.generator.GeneratorPath.GenerateFile.HELP_FILE;
import static cool.happycoding.code.initializr.generator.GeneratorPath.GenerateFile.README_FILE;

/**
 * <p>SrcMainResGenerator.java</P>
 *
 * @author lanlanhappy
 * @date 2021/01/16 5:36 下午
 */
public class MarkdownGenerator implements Generator{

    private final GenerationConfiguration generationConfiguration;

    public MarkdownGenerator(GenerationConfiguration generationConfiguration){
        this.generationConfiguration = generationConfiguration;
    }

    @Override
    public void generator() {
        // 生成readme.md
        new BaseGenerator(generationConfiguration, README_FILE).generator();
        // 生成help.md
        new BaseGenerator(generationConfiguration, HELP_FILE).generator();
    }
}
