package cool.happycoding.code.initializr.mybatis;

import com.baomidou.mybatisplus.generator.config.ConstVal;

/**
 * <p>HappyConstVal.java</P>
 *
 * @author lanlanhappy
 * @date 2021/03/12 3:07 下午
 */
public interface HappyConstVal extends ConstVal {

    String ADD_FORM         = "AddForm";
    String QRY_FORM         = "QryForm";
    String QRY_PAGE_FORM    = "QryPageForm";
    String UPDATE_FORM      = "UpdateForm";
    String DTO              = "Dto";


    String ADD_FORM_PATH        = "add_form_path";
    String QRY_FORM_PATH        = "qry_form_path";
    String QRY_PAGE_FORM_PATH   = "qry_page_form_path";
    String UPDATE_FORM_PATH     = "update_form_path";
    String DTO_PATH             = "dto_path";

    String TEMPLATE_ADD_FORM        = "/templates/addForm.java";
    String TEMPLATE_QRY_FORM        = "/templates/qryForm.java";
    String TEMPLATE_QRY_PAGE_FORM   = "/templates/qryPageForm.java";
    String TEMPLATE_UPDATE_FORM     = "/templates/updateForm.java";
    String TEMPLATE_DTO             = "/templates/dto.java";

}
