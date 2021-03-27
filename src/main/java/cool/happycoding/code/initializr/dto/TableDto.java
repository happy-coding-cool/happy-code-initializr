package cool.happycoding.code.initializr.dto;

import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.base.pojo.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName TableDto
 * @Description TODO
 * @Author lanlanhappy
 * @Date 2021/01/06 5:43 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableDto extends DTO implements Comparable<TableDto>{
    /**
     * 表名
     */
    private String name;
    /**
     * 注释
     */
    private String comment;

    @Override
    public int compareTo(TableDto o) {
        return StrUtil.compareIgnoreCase(this.getName(), o.getName() ,true);
    }
}
