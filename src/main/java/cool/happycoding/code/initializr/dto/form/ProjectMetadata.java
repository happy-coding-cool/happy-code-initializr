package cool.happycoding.code.initializr.dto.form;

import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.base.pojo.Form;
import lombok.Data;

import static cool.happycoding.code.initializr.generator.Config.DEFAULT_JDK_VERSION;

/**
 * @ClassName ProjectMetadata
 * @Description 项目元数据
 * @Author lanlanhappy
 * @Date 2020/12/28 10:10 下午
 */
@Data
public class ProjectMetadata extends Form {

    private String  group;
    private String  artifact;
    private String  name;
    private String  proPackage;
    private String  description;
    private String  javaVersion;

    public String getJavaVersion() {
        return StrUtil.blankToDefault(javaVersion, DEFAULT_JDK_VERSION);
    }
}
