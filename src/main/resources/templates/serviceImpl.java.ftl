package ${package.ServiceImpl};

import cn.hutool.core.util.ObjectUtil;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import ${package.AddForm}.${entity}AddForm;
import ${package.QryForm}.${entity}QryForm;
import ${package.QryPageForm}.${entity}QryPageForm;
import ${package.UpdateForm}.${entity}UpdateForm;
import ${package.Dto}.${entity}Dto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.happycoding.code.base.util.HappyCodeUtil;
import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {


     @Override
     public ${entity}Dto get(String id) {
        ${entity} ${entity?uncap_first} = this.getById(id);
        if(ObjectUtil.isNotNull(${entity?uncap_first})){
            return ${entity?uncap_first}.toDTO(${entity}Dto.class);
        }
        return null;
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public ${entity}Dto save(${entity}AddForm ${entity?uncap_first}AddForm) {
        ${entity} ${entity?uncap_first} = ${entity?uncap_first}AddForm.toEntity(${entity}.class);
        this.save(${entity?uncap_first});
        return ${entity?uncap_first}.toDTO(${entity}Dto.class);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean update(${entity}UpdateForm ${entity?uncap_first}UpdateForm) {
        ${entity} ${entity?uncap_first} = ${entity?uncap_first}UpdateForm.toEntity(${entity}.class);
        return this.updateById(${entity?uncap_first});
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean delete(String id) {
        return this.removeById(id);
     }

     @Override
     public List<${entity}Dto> list(${entity}QryForm ${entity?uncap_first}QryForm) {
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
        // TODO 构造查询条件
        List<${entity}> ${entity?uncap_first}s = this.list(queryWrapper);
        return HappyCodeUtil.copy(${entity?uncap_first}s, ${entity}Dto.class);

     }

     @Override
     public IPage<${entity}Dto> page(${entity}QryPageForm ${entity?uncap_first}QryPageForm) {
         QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
         // TODO 构造查询条件
         return this.page(new Page<>(${entity?uncap_first}QryPageForm.getCurrent(), ${entity?uncap_first}QryPageForm.getSize()),
                    queryWrapper).convert(${entity?uncap_first}->${entity?uncap_first}.toDTO(${entity}Dto.class));
      }

}
</#if>