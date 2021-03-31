package cool.happycoding.code.initializr.generator;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import cool.happycoding.code.base.util.DateUtils;
import cool.happycoding.code.initializr.dto.form.Dependency;
import cool.happycoding.code.initializr.dto.form.HappyCodeForm;
import cool.happycoding.code.initializr.utils.GenerateUtils;
import freemarker.template.Configuration;
import lombok.Data;

import java.util.Map;
import java.util.stream.Collectors;

import static cn.hutool.core.util.StrUtil.toCamelCase;
import static cn.hutool.core.util.StrUtil.upperFirst;

/**
 * @ClassName GenerationConfig
 * @Description 代码生成配置
 * @Author lanlanhappy
 * @Date 2020/12/30 8:18 下午
 */
@Data
public class GenerationConfig implements Config{

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

    public static GenerationConfig of(Configuration configuration, HappyCodeForm happyCodeForm){
        GenerationConfig generationConfig = new GenerationConfig();
        generationConfig.setConfiguration(configuration);
        generationConfig.setHappyCodeForm(happyCodeForm);
        return generationConfig;
    }

    public boolean enableDatabase(){
        return ObjectUtil.isNotNull(happyCodeForm)
                && GenerateUtils.enableDatabase(happyCodeForm.getDatabase());
    }

    /**
     * freemarker 模板参数
     * @return
     */
    public Map<String, Object> buildGenerateParamMap(){

        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("author", happyCodeForm.getAuthor());
        paramMap.put("date", DateUtils.now());
        paramMap.put("happyCodeVersion", happyCodeForm.getHappyCodeVersion());
        paramMap.put("projectMetadata", happyCodeForm.getProjectMetadata());
        paramMap.put("artifactToCamelCase", upperFirst(toCamelCase(StrUtil.replaceChars(happyCodeForm.getProjectMetadata().getArtifact(), "-","_"))));
        if (enableDatabase()){
            paramMap.put("database", happyCodeForm.getDatabase());
            Dependency dependency = new Dependency();
            dependency.setDependency("enableMybatisPlus");
            happyCodeForm.setDependencies(Lists.newArrayList(dependency));
        }
        // 依赖校验
        paramMap.putAll(
                Dependencies.checkEnable(
                        happyCodeForm.getDependencies()
                                .stream()
                                .map(Dependency::getDependency)
                                .collect(Collectors.toList())));
        return paramMap;
    }

}
