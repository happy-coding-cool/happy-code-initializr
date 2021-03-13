package cool.happycoding.code.initializr.mybatis;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import cool.happycoding.code.initializr.generator.GenerationConfig;

import java.io.File;
import java.util.Map;

import static cool.happycoding.code.initializr.mybatis.HappyConstVal.*;

/**
 * <p>HappyInjectionConfig.java</P>
 *
 * @author lanlanhappy
 * @date 2021/03/12 2:42 下午
 */
public class HappyInjectionConfig extends InjectionConfig{

    private final GenerationConfig generationConfig;
    private final String outPath;
    private final String parent;

    public HappyInjectionConfig(GenerationConfig generationConfig){
        this.generationConfig = generationConfig;
        this.outPath = generationConfig.getZipFilePath() + "/src/main/java";
        this.parent = generationConfig.getHappyCodeForm().getProjectMetadata().getProPackage();
    }
    @Override
    public void initMap() {
        this.setMap(generationConfig.buildGenerateParamMap());
    }

    @Override
    public InjectionConfig setConfig(ConfigBuilder config) {
        postConfig(config.getPackageInfo(), config.getPathInfo());
        super.setConfig(config);
        return this;
    }

    private void postConfig(Map<String, String> packageInfo, Map<String, String> pathInfo){

        // 添加扩展类对应的package配置
        packageInfo.put(HappyConstVal.ADD_FORM,      parent + ".dto.form");
        packageInfo.put(HappyConstVal.QRY_FORM,      parent + ".dto.form");
        packageInfo.put(HappyConstVal.QRY_PAGE_FORM, parent + ".dto.form");
        packageInfo.put(HappyConstVal.UPDATE_FORM,   parent + ".dto.form");
        packageInfo.put(HappyConstVal.DTO,           parent + ".dto");

        // 添加扩展类对应的生成路径
        pathInfo.put(ADD_FORM_PATH, joinPath(outPath, packageInfo.get(HappyConstVal.ADD_FORM)));
        pathInfo.put(QRY_FORM_PATH, joinPath(outPath, packageInfo.get(HappyConstVal.QRY_FORM)));
        pathInfo.put(QRY_PAGE_FORM_PATH, joinPath(outPath, packageInfo.get(HappyConstVal.QRY_PAGE_FORM)));
        pathInfo.put(UPDATE_FORM_PATH, joinPath(outPath, packageInfo.get(HappyConstVal.UPDATE_FORM)));
        pathInfo.put(DTO_PATH, joinPath(outPath, packageInfo.get(HappyConstVal.DTO)));
    }

    private String joinPath(String parentDir, String packageName) {
        if (StringUtils.isBlank(parentDir)) {
            parentDir = System.getProperty(ConstVal.JAVA_TMPDIR);
        }
        if (!StringUtils.endsWith(parentDir, File.separator)) {
            parentDir += File.separator;
        }
        packageName = packageName.replaceAll("\\.", StringPool.BACK_SLASH + File.separator);
        return parentDir + packageName;
    }
}
