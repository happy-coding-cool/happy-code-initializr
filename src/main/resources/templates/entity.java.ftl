package ${package.Entity};

<#list table.importPackages as pkg>
    <#if pkg != "java.io.Serializable"
    && pkg != "com.baomidou.mybatisplus.annotation.IdType"
    && pkg != "com.baomidou.mybatisplus.annotation.TableId">
import ${pkg};
    </#if>
</#list>
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import cool.happycoding.code.mybatis.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 * ${table.comment!}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Data
@TableName("${table.name}")
public class ${entity} extends BaseEntity {

<#if entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
</#if>
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
<#-- 以下字段忽略 -->
    <#if field.propertyName != "id"
        && field.propertyName != "createdBy"
        && field.propertyName != "createdTime"
        && field.propertyName != "updatedBy"
        && field.propertyName != "updatedTime"
        && field.propertyName != "updatedById"
        && field.propertyName != "createdById"
    >
    <#if field.keyFlag>
        <#assign keyPropertyName="${field.propertyName}"/>
    </#if>
    <#if field.comment!?length gt 0>
    /**
     * ${field.comment?replace("\r\n"," ")}
     */
    </#if>
    @TableField("${field.name}")
    private ${field.propertyType} ${field.propertyName};

    </#if>
</#list>
}
