package cool.happycoding.code.initializr.dto;

import cool.happycoding.code.base.pojo.DTO;
import lombok.Data;

/**
 * @ClassName TableDTO
 * @Description TODO
 * @Author lanlanhappy
 * @Date 2021/01/06 5:43 下午
 */
@Data
public class TableDTO extends DTO {
    /**
     * 表名
     */
    private String name;
    /**
     * 注释
     */
    private String comment;
}
