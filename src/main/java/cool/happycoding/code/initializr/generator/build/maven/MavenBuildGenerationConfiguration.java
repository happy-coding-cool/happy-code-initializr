package cool.happycoding.code.initializr.generator.build.maven;

import cool.happycoding.code.initializr.api.v1.form.HappyCodeForm;
import cool.happycoding.code.initializr.base.AbstractGenerationConfiguration;
import cool.happycoding.code.initializr.base.GenerationConfiguration;
import freemarker.template.Configuration;

/**
 * @ClassName MavenBuildGenerationConfiguration
 * @Description maven配置生成
 * @Author lanlanhappy
 * @Date 2020/12/31 9:13 上午
 */
public class MavenBuildGenerationConfiguration extends AbstractGenerationConfiguration {


    public MavenBuildGenerationConfiguration(Configuration configuration, HappyCodeForm happyCodeForm) {
        super(configuration, happyCodeForm);
    }
}
