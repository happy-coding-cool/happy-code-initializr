package cool.happycoding.code.initializr.dto.form;

import cool.happycoding.code.base.pojo.Form;
import lombok.Data;

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
    private String  projectName;
    private String  javaVersion;
}
