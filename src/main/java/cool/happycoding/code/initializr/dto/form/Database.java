package cool.happycoding.code.initializr.dto.form;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import  cool.happycoding.code.base.pojo.Form;
import cool.happycoding.code.initializr.generator.Config;
import lombok.Data;

import java.util.List;

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

    private List<String> tables;

    private String tablePrefix;

    /**
     * 生成mysql 连接 url
     * @return
     */
    public String mysqlConn(){
        return String
                .format(Config.MYSQL_URL, host, port, schema);
    }

    public List<String> getTables() {
        if(CollUtil.isEmpty(tables)){
            return Lists.newArrayList();
        }
        return this.tables;
    }

    public List<String> getTablePrefix() {
        if(StrUtil.isEmpty(tablePrefix)){
            return Lists.newArrayList();
        }
        return Lists.newArrayList(StrUtil.split(this.tablePrefix,","));
    }
}
