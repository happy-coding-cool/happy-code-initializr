package cool.happycoding.code.initializr.generator.dependency.mq;

import cool.happycoding.code.initializr.api.v1.form.HappyCodeForm;
import cool.happycoding.code.initializr.base.AbstractGenerationConfiguration;
import cool.happycoding.code.initializr.base.GenerationConfiguration;
import freemarker.template.Configuration;

/**
 * @ClassName MqGenerationConfiguration
 * @Description mq生成
 * @Author lanlanhappy
 * @Date 2020/12/30 9:54 下午
 */
public class MqGenerationConfiguration extends AbstractGenerationConfiguration {


    public MqGenerationConfiguration(Configuration configuration, HappyCodeForm happyCodeForm) {
        super(configuration, happyCodeForm);
    }
}
