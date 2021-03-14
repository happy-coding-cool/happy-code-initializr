package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import ${package.AddForm}.${entity}AddForm;
import ${package.QryForm}.${entity}QryForm;
import ${package.QryPageForm}.${entity}QryPageForm;
import ${package.UpdateForm}.${entity}UpdateForm;
import ${package.Dto}.${entity}Dto;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
     * 获取${table.comment}
     *
     * @param id ${table.comment}id
     * @return ${entity}Dto
     */
    ${entity}Dto get(String id);

    /**
     * 获取${table.comment}
     *
     * @param ${entity?uncap_first}AddForm
     * @return ${entity}Dto
     */
    ${entity}Dto save(${entity}AddForm ${entity?uncap_first}AddForm);

    /**
     * 更新${table.comment}信息
     *
     * @param ${entity?uncap_first}UpdateForm
     * @return
     */
    boolean update(${entity}UpdateForm ${entity?uncap_first}UpdateForm);

    /**
     * 根据id删除${table.comment}
     *
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 查询${table.comment}
     *
     * @param ${entity?uncap_first}QryForm
     * @return
     */
    List<${entity}Dto> list(${entity}QryForm ${entity?uncap_first}QryForm);

    /**
     * 查询${table.comment}
     * @param ${entity?uncap_first}QryPageForm
     * @return
     */
    IPage<${entity}Dto> page(${entity}QryPageForm ${entity?uncap_first}QryPageForm);
}
</#if>