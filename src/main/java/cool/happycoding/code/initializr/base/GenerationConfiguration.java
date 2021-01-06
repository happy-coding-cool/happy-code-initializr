package cool.happycoding.code.initializr.base;

import cool.happycoding.code.initializr.api.v1.form.HappyCodeForm;
import freemarker.template.Configuration;

/**
 * @ClassName GenerationConfiguration
 * @Description 代码生成配置
 * @Author lanlanhappy
 * @Date 2020/12/30 8:18 下午
 */
public interface GenerationConfiguration {
    /**
     * 获取 配置
     * @return
     */
    Configuration getConfiguration();

    /**
     * 获取 生成参数
     * @return
     */
    HappyCodeForm getHappyCodeForm();
}
