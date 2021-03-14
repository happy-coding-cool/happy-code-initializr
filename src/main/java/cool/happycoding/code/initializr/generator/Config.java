package cool.happycoding.code.initializr.generator;

/**
 * <p>Config.java</P>
 *
 * @author lanlanhappy
 * @date 2021/03/08 10:03 下午
 */
public interface Config {

    String DEFAULT_JDK_VERSION = "1.8";
    String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    String MYSQL_URL = "jdbc:mysql://%s:%s/%s?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false&zeroDateTimeBehavior=convertToNull";

}
