package cool.happycoding.code.initializr.generator;

import cool.happycoding.code.initializr.api.v1.form.HappyCodeForm;
import freemarker.template.Configuration;
import lombok.Data;

/**
 * @ClassName GenerationConfiguration
 * @Description 代码生成配置
 * @Author lanlanhappy
 * @Date 2020/12/30 8:18 下午
 */
@Data
public class GenerationConfiguration {

    /**
     * 获取 配置
     * @return
     */
    private Configuration configuration;

    /**
     * 获取 生成参数
     * @return
     */
    private HappyCodeForm happyCodeForm;


}