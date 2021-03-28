package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import ${package.AddForm}.${entity}AddForm;
import ${package.QryForm}.${entity}QryForm;
import ${package.QryPageForm}.${entity}QryPageForm;
import ${package.UpdateForm}.${entity}UpdateForm;
import ${package.Dto}.${entity}Dto;
import ${package.Service}.${table.serviceName};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cool.happycoding.code.base.result.BaseResult;
import cool.happycoding.code.base.result.ListResult;
import cool.happycoding.code.base.result.PageResult;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */

@Validated
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@Api(tags="${table.comment}")
@RequiredArgsConstructor
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    /**
     * ${table.comment!} 服务类
     */
    private final ${table.serviceName} ${table.serviceImplName?uncap_first};

    @ApiOperation(value = "新增${table.comment}", notes = "新增${table.comment}")
    @PostMapping
    public BaseResult<${entity}Dto> add(@RequestBody ${entity}AddForm ${entity?uncap_first}AddForm) {
       return BaseResult.success(${table.serviceImplName?uncap_first}.save(${entity?uncap_first}AddForm));
    }

    @ApiOperation(value = "删除${table.comment}", notes = "根据url的id来指定删除对象")
    @DeleteMapping(value = "/{id}")
    public BaseResult<Boolean> delete(@PathVariable String id) {
       return BaseResult.success(${table.serviceImplName?uncap_first}.delete(id));
    }

    @ApiOperation(value = "修改${table.comment}", notes = "修改指定${table.comment}信息")
    @PutMapping(value = "/{id}")
    public BaseResult<Boolean> update(@PathVariable String id,
            @RequestBody ${entity}UpdateForm ${entity?uncap_first}UpdateForm) {
       ${entity?uncap_first}UpdateForm.setId(id);
       return BaseResult.success(${table.serviceImplName?uncap_first}.update(${entity?uncap_first}UpdateForm));
    }

    @ApiOperation(value = "获取${table.comment}", notes = "获取指定${table.comment}信息")
    @GetMapping(value = "/{id}")
    public BaseResult<${entity}Dto> get(@PathVariable String id) {
       return BaseResult.success(${table.serviceImplName?uncap_first}.get(id));
    }

    @ApiOperation(value = "搜索${table.comment}", notes = "根据条件查询${table.comment}信息")
    @PostMapping(value = "/list")
    public ListResult<${entity}Dto> list(@RequestBody ${entity}QryForm ${entity?uncap_first}QryForm) {
        return ListResult.success(${table.serviceImplName?uncap_first}.list(${entity?uncap_first}QryForm));
    }

    @ApiOperation(value = "分页搜索${table.comment}", notes = "根据条件分页查询${table.comment}信息")
    @PostMapping(value = "/page")
    public PageResult<${entity}Dto> page(@RequestBody ${entity}QryPageForm ${entity?uncap_first}QryPageForm) {
        IPage<${entity}Dto> page = ${table.serviceImplName?uncap_first}.page(${entity?uncap_first}QryPageForm);
        return PageResult.success(page.getCurrent(), page.getPages(), page.getTotal(), page.getRecords());
    }

}
</#if>