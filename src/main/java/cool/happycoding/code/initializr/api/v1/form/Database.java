package cool.happycoding.code.initializr.api.v1.form;

import cool.happycoding.code.base.pojo.Form;
import lombok.Data;

/**
 * @ClassName Database
 * @Description 数据库配置
 * @Author lanlanhappy
 * @Date 2020/12/28 10:21 下午
 */
@Data
public class Database extends Form {

    private String host;
    private String port;
    private String username;
    private String password;
    private String schema;

}
