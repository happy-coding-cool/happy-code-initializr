package cool.happycoding.code.initializr.generator;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>Dependencies.java 穷举所有组件依赖描述</P>
 *
 * @author lanlanhappy
 * @date 2021/03/14 5:49 下午
 */
public enum Dependencies {

    /**
     * mybatis-plus
     */
    MYBATIS_PLUS("enableMybatisPlus", true),

    /**
     * jet-cache
     */
    JET_CACHE("enableJetCache", true),

    /**
     * rocket-mq
     */
    ROCKET_MQ("enableRocketMQ", true)
    ;

    String name;
    boolean enable;

    Dependencies(String name, boolean enable){
        this.name = name;
        this.enable = enable;
    }

    public String getName() {
        return name;
    }

    public boolean getEnable() {
        return enable;
    }

    public static Map<String, Object> checkEnable(List<String> names){
        Map<String,Object> depMap = Maps.newHashMap();
        Arrays.stream(Dependencies.values()).forEach(dep -> {
            depMap.put(dep.getName(), names.contains(dep.getName()));
        });
        return depMap;
    }
}
