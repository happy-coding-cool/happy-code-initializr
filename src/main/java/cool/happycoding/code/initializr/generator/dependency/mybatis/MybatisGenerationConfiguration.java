package cool.happycoding.code.initializr.generator.dependency.mybatis;

import cool.happycoding.code.initializr.api.v1.form.HappyCodeForm;
import cool.happycoding.code.initializr.base.AbstractGenerationConfiguration;
import cool.happycoding.code.initializr.base.GenerationConfiguration;
import freemarker.template.Configuration;

/**
 * @ClassName MybatisGenerationConfiguration
 * @Description mybatis生成
 * @Author lanlanhappy
 * @Date 2020/12/30 9:54 下午
 */
public class MybatisGenerationConfiguration extends AbstractGenerationConfiguration {

    public MybatisGenerationConfiguration(Configuration configuration, HappyCodeForm happyCodeForm) {
        super(configuration, happyCodeForm);
    }
}
