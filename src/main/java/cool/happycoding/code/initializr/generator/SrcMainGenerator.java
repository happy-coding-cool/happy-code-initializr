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

    private final GenerationConfig generationConfig;

    public SrcMainGenerator(GenerationConfig generationConfig){
        this.generationConfig = generationConfig;
    }

    @Override
    public void generator() {
        // main 方法
        new BaseGenerator(generationConfig, GeneratorPath.GenerateFile.APPLICATION_JAVA_FILE).generator();
        // resources 文件生成
        new BaseGenerator(generationConfig, APPLICATION_FILE).generator();
        // 生成
        if (ObjectUtil.isNotNull(generationConfig.getHappyCodeForm().getDatabase())){
            new MybatisGenerator(generationConfig).generator();
        }
    }
}
