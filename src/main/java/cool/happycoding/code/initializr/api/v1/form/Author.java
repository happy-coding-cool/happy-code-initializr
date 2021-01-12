package cool.happycoding.code.initializr.api.v1.form;
import  cool.happycoding.code.base.pojo.Form;
import lombok.Data;

/**
 * @ClassName Author
 * @Description 作者信息
 * @Author lanlanhappy
 * @Date 2021/01/12 10:13 下午
 */
@Data
public class Author extends Form{

    private String name;
    private String email;

}
