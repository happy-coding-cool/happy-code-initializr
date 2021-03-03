package cool.happycoding.code.initializr.generator;

/**
 * <p>SrcTestGenerator.java</P>
 *
 * @author lanlanhappy
 * @date 2021/01/16 5:37 下午
 */
public class SrcTestGenerator implements Generator{

    private final GenerationConfiguration generationConfiguration;

    public SrcTestGenerator(GenerationConfiguration generationConfiguration){
        this.generationConfiguration = generationConfiguration;
    }


    @Override
    public void generator() {
        // TODO 测试用例生成
    }
}
