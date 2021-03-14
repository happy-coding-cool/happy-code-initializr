package ${package.QryPageForm};

import cool.happycoding.code.base.pojo.PageForm;
<#list table.importPackages as pkg>
    <#if pkg != "java.io.Serializable"
    && pkg != "io.swagger.annotations.ApiModel"
    && pkg != "io.swagger.annotations.ApiModelProperty"
    && pkg != "com.baomidou.mybatisplus.annotation.TableName">
import ${pkg};
    </#if>
</#list>
<#if swagger2>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
<#if entityLombokModel>
import lombok.Data;
</#if>

/**
 * <p>
 * ${table.comment!} 分页查询
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Data
@ApiModel(value="${entity}QryPageForm对象", description="${table.comment!}分页查询")
public class ${entity}QryPageForm extends PageForm {

<#if entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
</#if>

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
<#-- 以下字段忽略 -->
    <#if
    field.propertyName != "createdBy"
    && field.propertyName != "createdTime"
    && field.propertyName != "updatedBy"
    && field.propertyName != "updatedTime"
    && field.propertyName != "updatedById"
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