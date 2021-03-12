package cool.happycoding.code.initializr.mybatis;

import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import cool.happycoding.code.initializr.generator.GenerationConfiguration;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * <p>HappyFreemarkerTemplateEngine.java</P>
 *
 * @author lanlanhappy
 * @date 2021/03/10 9:32 下午
 */
@Slf4j
public class HappyFreemarkerTemplateEngine extends FreemarkerTemplateEngine {

    private final GenerationConfiguration generationConfiguration;

    public HappyFreemarkerTemplateEngine(GenerationConfiguration generationConfiguration){
        this.generationConfiguration = generationConfiguration;
    }

    @Override
    public AbstractTemplateEngine batchOutput() {
        try{
            List<TableInfo> tableInfoList = getConfigBuilder().getTableInfoList();
            for (TableInfo tableInfo: tableInfoList) {
                Map<String, Object> objectMap = getObjectMap(tableInfo);
                Map<String, String> pathInfo = getConfigBuilder().getPathInfo();
                HappyTemplateConfig template = (HappyTemplateConfig) getConfigBuilder().getTemplate();

                outputAddForm(tableInfo, pathInfo, objectMap, template);
                outputQryForm(tableInfo, pathInfo, objectMap, template);
                outputQryPageForm(tableInfo, pathInfo, objectMap, template);
                outputUpdateForm(tableInfo, pathInfo, objectMap, template);
                outputDto(tableInfo, pathInfo, objectMap, template);

                outputEntity(tableInfo, pathInfo, objectMap, template);
                outputController(tableInfo, pathInfo, objectMap, template);
                outputService(tableInfo, pathInfo, objectMap, template);
                outputMapper(tableInfo, pathInfo, objectMap, template);
            }
        } catch (Exception e) {
            logger.error("无法创建文件，请检查配置信息！", e);
        }
        return this;
    }

    /**
     * 生成 AddForm
     */
    @SneakyThrows
    private void outputAddForm(TableInfo tableInfo, Map<String, String> pathInfo, Map<String, Object> objectMap, HappyTemplateConfig template){
        String entityName = tableInfo.getEntityName();
        if (null != entityName && null != pathInfo.get(HappyConstVal.ADD_FORM_PATH)) {
            String outFile = String.format((pathInfo.get(HappyConstVal.ADD_FORM_PATH) + File.separator + "%sAddForm" + suffixJavaOrKt()), entityName);
            writerFile(objectMap, templateFilePath(template.getAddForm()), outFile);
        }
    }

    /**
     * 生成 QryForm
     */
    @SneakyThrows
    private void outputQryForm(TableInfo tableInfo, Map<String, String> pathInfo, Map<String, Object> objectMap, HappyTemplateConfig template){
        String entityName = tableInfo.getEntityName();
        if (null != entityName && null != pathInfo.get(HappyConstVal.QRY_FORM_PATH)) {
            String outFile = String.format((pathInfo.get(HappyConstVal.QRY_FORM_PATH) + File.separator + "%sQryForm" + suffixJavaOrKt()), entityName);
            writerFile(objectMap, templateFilePath(template.getQryForm()), outFile);
        }
    }

    /**
     * 生成 QryPageForm
     */
    @SneakyThrows
    private void outputQryPageForm(TableInfo tableInfo, Map<String, String> pathInfo, Map<String, Object> objectMap, HappyTemplateConfig template){
        String entityName = tableInfo.getEntityName();
        if (null != entityName && null != pathInfo.get(HappyConstVal.QRY_PAGE_FORM_PATH)) {
            String outFile = String.format((pathInfo.get(HappyConstVal.QRY_PAGE_FORM_PATH) + File.separator + "%sQryPageForm" + suffixJavaOrKt()), entityName);
            writerFile(objectMap, templateFilePath(template.getQryPageForm()), outFile);
        }
    }

    /**
     * 生成 UpdateForm
     */
    @SneakyThrows
    private void outputUpdateForm(TableInfo tableInfo, Map<String, String> pathInfo, Map<String, Object> objectMap, HappyTemplateConfig template){
        String entityName = tableInfo.getEntityName();
        if (null != entityName && null != pathInfo.get(HappyConstVal.UPDATE_FORM_PATH)) {
            String outFile = String.format((pathInfo.get(HappyConstVal.UPDATE_FORM_PATH) + File.separator + "%sUpdateForm" + suffixJavaOrKt()), entityName);
            writerFile(objectMap, templateFilePath(template.getUpdateForm()), outFile);
        }
    }

    /**
     * 生成 dto
     */
    @SneakyThrows
    private void outputDto(TableInfo tableInfo, Map<String, String> pathInfo, Map<String, Object> objectMap, HappyTemplateConfig template){
        String entityName = tableInfo.getEntityName();
        if (null != entityName && null != pathInfo.get(HappyConstVal.DTO_PATH)) {
            String outFile = String.format((pathInfo.get(HappyConstVal.DTO_PATH) + File.separator + "%sDto" + suffixJavaOrKt()), entityName);
            writerFile(objectMap, templateFilePath(template.getDto()), outFile);
        }
    }

    /**
     * 生成 UpdateForm
     */
    @SneakyThrows
    private void outputEntity(TableInfo tableInfo, Map<String, String> pathInfo, Map<String, Object> objectMap, TemplateConfig template){
        String entityName = tableInfo.getEntityName();
        if (null != entityName && null != pathInfo.get(ConstVal.ENTITY_PATH)) {
            String entityFile = String.format((pathInfo.get(ConstVal.ENTITY_PATH) + File.separator + "%s" + suffixJavaOrKt()), entityName);
            if (isCreate(FileType.ENTITY, entityFile)) {
                writerFile(objectMap, templateFilePath(template.getEntity(getConfigBuilder().getGlobalConfig().isKotlin())), entityFile);
            }
        }
    }

    /**
     * MpMapper.java/MpMapper.xml
     */
    @SneakyThrows
    private void outputMapper(TableInfo tableInfo, Map<String, String> pathInfo, Map<String, Object> objectMap, TemplateConfig template){
        String entityName = tableInfo.getEntityName();
        if (null != tableInfo.getMapperName() && null != pathInfo.get(ConstVal.MAPPER_PATH)) {
            String mapperFile = String.format((pathInfo.get(ConstVal.MAPPER_PATH) + File.separator + tableInfo.getMapperName() + suffixJavaOrKt()), entityName);
            if (isCreate(FileType.MAPPER, mapperFile)) {
                writerFile(objectMap, templateFilePath(template.getMapper()), mapperFile);
            }
        }

        if (null != tableInfo.getXmlName() && null != pathInfo.get(ConstVal.XML_PATH)) {
            String xmlFile = String.format((generationConfiguration.getZipFilePath() + File.separator + "src/main/resources/mapper/" + tableInfo.getXmlName() + ConstVal.XML_SUFFIX), entityName);
            if (isCreate(FileType.XML, xmlFile)) {
                writerFile(objectMap, templateFilePath(template.getXml()), xmlFile);
            }
        }
    }

    /**
     * Service.java
     */
    @SneakyThrows
    private void outputService(TableInfo tableInfo, Map<String, String> pathInfo, Map<String, Object> objectMap, TemplateConfig template){
        String entityName = tableInfo.getEntityName();
        // IMpService.java
        if (null != tableInfo.getServiceName() && null != pathInfo.get(ConstVal.SERVICE_PATH)) {
            String serviceFile = String.format((pathInfo.get(ConstVal.SERVICE_PATH) + File.separator + tableInfo.getServiceName() + suffixJavaOrKt()), entityName);
            if (isCreate(FileType.SERVICE, serviceFile)) {
                writerFile(objectMap, templateFilePath(template.getService()), serviceFile);
            }
        }
        // MpServiceImpl.java
        if (null != tableInfo.getServiceImplName() && null != pathInfo.get(ConstVal.SERVICE_IMPL_PATH)) {
            String implFile = String.format((pathInfo.get(ConstVal.SERVICE_IMPL_PATH) + File.separator + tableInfo.getServiceImplName() + suffixJavaOrKt()), entityName);
            if (isCreate(FileType.SERVICE_IMPL, implFile)) {
                writerFile(objectMap, templateFilePath(template.getServiceImpl()), implFile);
            }
        }
    }


    /**
     * Controller.java
     */
    @SneakyThrows
    private void outputController(TableInfo tableInfo, Map<String, String> pathInfo, Map<String, Object> objectMap, TemplateConfig template){
        String entityName = tableInfo.getEntityName();
        // MpController.java
        if (null != tableInfo.getControllerName() && null != pathInfo.get(ConstVal.CONTROLLER_PATH)) {
            String controllerFile = String.format((pathInfo.get(ConstVal.CONTROLLER_PATH) + File.separator + tableInfo.getControllerName() + suffixJavaOrKt()), entityName);
            if (isCreate(FileType.CONTROLLER, controllerFile)) {
                writerFile(objectMap, templateFilePath(template.getController()), controllerFile);
            }
        }
    }


}

