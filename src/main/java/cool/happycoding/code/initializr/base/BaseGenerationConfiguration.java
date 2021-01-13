package cool.happycoding.code.initializr.base;

import cool.happycoding.code.initializr.api.v1.form.HappyCodeForm;
import freemarker.template.Configuration;

/**
 * @ClassName BaseGenerationConfiguration
 * @Description TODO
 * @Author lanlanhappy
 * @Date 2021/01/13 8:30 上午
 */
public class BaseGenerationConfiguration extends AbstractGenerationConfiguration{

    public BaseGenerationConfiguration(Configuration configuration, HappyCodeForm happyCodeForm) {
        super(configuration, happyCodeForm);
    }

    public static BaseGenerationConfiguration of(Configuration configuration, HappyCodeForm happyCodeForm){
        return new BaseGenerationConfiguration(configuration, happyCodeForm);
    }
}
