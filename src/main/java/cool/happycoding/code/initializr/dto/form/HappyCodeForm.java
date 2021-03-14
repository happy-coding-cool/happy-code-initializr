package cool.happycoding.code.initializr.dto.form;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import cool.happycoding.code.base.pojo.Form;
import lombok.Data;

import java.util.List;

import static cool.happycoding.code.initializr.generator.Config.DEFAULT_JDK_VERSION;

/**
 * @ClassName HappyCodeForm
 * @Description 生成请求参数
 * @Author lanlanhappy
 * @Date 2020/12/27 12:36 下午
 */
@Data
public class HappyCodeForm extends Form {

    private String build;
    private String happyCodeVersion;
    private Author author;
    private ProjectMetadata projectMetadata;
    private List<Dependency> dependencies;
    private Database database;

    public String getHappyCodeVersion() {
        return StrUtil.blankToDefault(happyCodeVersion, DEFAULT_JDK_VERSION);
    }

    public List<Dependency> getDependencies() {
        return CollUtil.isEmpty(dependencies) ? Lists.newArrayList() : dependencies;
    }
}
