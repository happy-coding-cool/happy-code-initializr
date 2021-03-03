package cool.happycoding.code.initializr.generator;

import cn.hutool.core.io.FileUtil;
import com.google.common.collect.Lists;
import cool.happycoding.code.base.exception.BizException;
import cool.happycoding.code.initializr.dto.form.HappyCodeForm;
import cool.happycoding.code.initializr.dto.form.ProjectMetadata;
import freemarker.template.Configuration;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import static cool.happycoding.code.base.common.HappyStatus.INTERNAL_SYSTEM_ERROR;
import static cool.happycoding.code.initializr.generator.GeneratorPath.GenerateFile.APPLICATION_JAVA_FILE;

/**
 * <p>BaseGenerator.java</P>
 *
 * @author lanlanhappy
 * @date 2021/01/16 4:34 下午
 */
@Slf4j
public class BaseGenerator implements Generator{

    private final HappyCodeForm happyCodeForm;
    private final Configuration configuration;
    private final String zipFilePath;
    private final Map<String, Object> paramMap;
    private final GeneratorPath.GenerateFile generateFile;

    public BaseGenerator(GenerationConfiguration generationConfiguration,
                         GeneratorPath.GenerateFile generateFile){

        this.generateFile = generateFile;
        this.paramMap = generationConfiguration.buildGenerateParamMap();
        this.zipFilePath = generationConfiguration.getZipFilePath();
        this.configuration = generationConfiguration.getConfiguration();
        this.happyCodeForm = generationConfiguration.getHappyCodeForm();
    }

    @Override
    public void generator() {
        List<String> formatArgs = Lists.newArrayList();
        formatArgs.add(zipFilePath);
        ProjectMetadata projectMetadata = happyCodeForm.getProjectMetadata();
        if (generateFile == APPLICATION_JAVA_FILE){
            // application 目录
            formatArgs.add(projectMetadata.getProPackage().replace('.','/'));
            formatArgs.add(String.valueOf(paramMap.get("artifactToCamelCase")));
        }
        try (final BufferedOutputStream outputStream =
                     FileUtil.getOutputStream(
                             String.format(generateFile.getFilePath(),
                                     formatArgs.toArray()))) {
            configuration.getTemplate(generateFile.getTemplatePath())
                    .process(paramMap,new OutputStreamWriter(outputStream, StandardCharsets.UTF_8.name()));
        }catch (Exception exception){
            log.error("error: {}" + exception.getMessage(), exception);
            throw new BizException(INTERNAL_SYSTEM_ERROR);
        }
    }


}