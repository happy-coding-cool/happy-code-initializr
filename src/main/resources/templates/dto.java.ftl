package ${package.Dto};

import cool.happycoding.code.mybatis.base.BaseDTO;
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
 * ${table.comment!} 前端展示对象
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Data
@ApiModel(value="${entity}Dto对象", description="${table.comment!}")
public class ${entity}Dto extends BaseDTO {

<#if entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
</#if>
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.comment!?length gt 0>
    @ApiModelProperty(value = "${field.comment?replace("\r\n"," ")}")
    <#else>
    @ApiModelProperty(value = "${field.name}")
    </#if>
    private ${field.propertyType} ${field.propertyName};

</#list>
}
