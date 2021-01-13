package cool.happycoding.code.initializr.base;

/**
 * @ClassName BaseGenerator
 * @Description TODO
 * @Author lanlanhappy
 * @Date 2021/01/13 8:29 上午
 */
public class BaseGenerator implements Generator{

    private final BaseGenerationConfiguration baseGenerationConfiguration;
    public BaseGenerator(BaseGenerationConfiguration baseGenerationConfiguration){
        this.baseGenerationConfiguration = baseGenerationConfiguration;
    }
    @Override
    public void generator() {

    }
}
