package cool.happycoding.code.initializr.mybatis;

import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import lombok.Data;

/**
 * <p>HappyTemplateConfig.java</P>
 *
 * @author lanlanhappy
 * @date 2021/03/10 9:59 下午
 */
@Data
public class HappyTemplateConfig extends TemplateConfig {

    private String addForm      =  HappyConstVal.TEMPLATE_ADD_FORM;
    private String qryForm      =  HappyConstVal.TEMPLATE_QRY_FORM;
    private String qryPageForm  =  HappyConstVal.TEMPLATE_QRY_PAGE_FORM;
    private String updateForm   =  HappyConstVal.TEMPLATE_UPDATE_FORM;
    private String dto          =  HappyConstVal.TEMPLATE_DTO;


}
