package cool.happycoding.code.initializr.generator;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Maps;
import cool.happycoding.code.initializr.dto.form.HappyCodeForm;
import freemarker.template.Configuration;
import lombok.Data;

import java.util.Map;

import static cn.hutool.core.util.StrUtil.toCamelCase;
import static cn.hutool.core.util.StrUtil.upperFirst;

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

    /**
     * zip file path
     */
    private String zipFilePath;

    public static GenerationConfiguration of(Configuration configuration, HappyCodeForm happyCodeForm){
        GenerationConfiguration generationConfiguration = new GenerationConfiguration();
        generationConfiguration.setConfiguration(configuration);
        generationConfiguration.setHappyCodeForm(happyCodeForm);
        return generationConfiguration;
    }

    /**
     * freemarker 模板参数
     * @return
     */
    public Map<String, Object> buildGenerateParamMap(){
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("author", happyCodeForm.getAuthor());
        paramMap.put("happyCodeVersion", happyCodeForm.getHappyCodeVersion());
        paramMap.put("projectMetadata", happyCodeForm.getProjectMetadata());
        paramMap.put("artifactToCamelCase", upperFirst(toCamelCase(StrUtil.replaceChars(happyCodeForm.getProjectMetadata().getArtifact(), "-","_"))));
        return paramMap;
    }

}
