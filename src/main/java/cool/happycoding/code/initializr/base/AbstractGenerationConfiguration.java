package cool.happycoding.code.initializr.base;

import cool.happycoding.code.initializr.api.v1.form.HappyCodeForm;
import freemarker.template.Configuration;

/**
 * @ClassName AbstractGenerationConfiguration
 * @Description 配置管理
 * @Author lanlanhappy
 * @Date 2021/01/06 5:50 下午
 */
public abstract class AbstractGenerationConfiguration implements GenerationConfiguration{

    private Configuration configuration;
    private HappyCodeForm happyCodeForm;

    public AbstractGenerationConfiguration(Configuration configuration, HappyCodeForm happyCodeForm){
        this.configuration = configuration;
        this.happyCodeForm = happyCodeForm;
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public HappyCodeForm getHappyCodeForm() {
        return happyCodeForm;
    }
}
