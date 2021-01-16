package cool.happycoding.code.initializr.generator;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * <p>BaseGenerator.java</P>
 *
 * @author lanlanhappy
 * @date 2021/01/16 4:34 下午
 */
public class BaseGenerator implements Generator{

    private GenerationConfiguration generationConfiguration;
    private GeneratorPath.GenerateFile generateFile;
    public BaseGenerator(GenerationConfiguration generationConfiguration,
                         GeneratorPath.GenerateFile generateFile){
        this.generationConfiguration = generationConfiguration;
        this.generateFile = generateFile;
    }

    @Override
    public void generator() {
        List<Object> formatArgs = Lists.newArrayList();
        formatArgs.add(generationConfiguration.getZipFilePath());

    }
}


