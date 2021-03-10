package ${package.Mapper};

import org.apache.ibatis.annotations.Mapper;

import ${superMapperClassPackage};
import ${package.Entity}.${entity};

/**
* <p>
    * ${table.comment!} Mapper 接口
    * </p>
*
* @author ${author}
* @since ${date}
*/
<#if kotlin>
    interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
    @Mapper
    public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

    }
</#if>
