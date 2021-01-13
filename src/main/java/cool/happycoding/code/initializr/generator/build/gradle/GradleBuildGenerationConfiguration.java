package cool.happycoding.code.initializr.generator.build.gradle;

import cool.happycoding.code.initializr.api.v1.form.HappyCodeForm;
import cool.happycoding.code.initializr.base.BaseGenerationConfiguration;
import freemarker.template.Configuration;

/**
 * @ClassName GradleBuildGenerationConfiguration
 * @Description Gradle配置生成
 * @Author lanlanhappy
 * @Date 2020/12/31 9:14 上午
 */
public class GradleBuildGenerationConfiguration extends BaseGenerationConfiguration {


    public GradleBuildGenerationConfiguration(Configuration configuration, HappyCodeForm happyCodeForm) {
        super(configuration, happyCodeForm);
    }
}
