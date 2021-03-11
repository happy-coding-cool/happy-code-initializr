package cool.happycoding.code.initializr.generator;

import cn.hutool.core.util.ObjectUtil;

import static cool.happycoding.code.initializr.generator.GeneratorPath.GenerateFile.APPLICATION_FILE;

/**
 * <p>SrcMainGenerator.java</P>
 *
 * @author lanlanhappy
 * @date 2021/01/16 5:36 下午
 */
public class SrcMainGenerator implements Generator{

    private final GenerationConfiguration generationConfiguration;

    public SrcMainGenerator(GenerationConfiguration generationConfiguration){
        this.generationConfiguration = generationConfiguration;
    }

    @Override
    public void generator() {
        // main 方法
        new BaseGenerator(generationConfiguration, GeneratorPath.GenerateFile.APPLICATION_JAVA_FILE).generator();
        // resources 文件生成
        new BaseGenerator(generationConfiguration, APPLICATION_FILE).generator();
        // 生成
        if (ObjectUtil.isNotNull(generationConfiguration.getHappyCodeForm().getDatabase())){
            new MybatisGenerator(generationConfiguration).generator();
        }
    }
}
