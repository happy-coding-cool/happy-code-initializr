package ${package.UpdateForm};

import cool.happycoding.code.mybatis.base.BaseForm;

<#if swagger2>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
<#if entityLombokModel>
import lombok.Data;
</#if>

/**
 * <p>
 * ${table.comment!} 更新
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Data
@ApiModel(value="${entity}UpdateForm对象", description="${table.comment!}更新")
public class ${entity}UpdateForm extends BaseForm {

<#if entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
</#if>

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
<#-- 以下字段忽略 -->
    <#if
    field.propertyName != "createdBy"
    && field.propertyName != "createdTime"
    && field.propertyName != "createdById"
    >
    <#if field.comment!?length gt 0>
    @ApiModelProperty(value = "${field.comment?replace("\r\n"," ")}")
    <#else>
    @ApiModelProperty(value = "${field.name}")
    </#if>
    private ${field.propertyType} ${field.propertyName};

    </#if>
</#list>
}