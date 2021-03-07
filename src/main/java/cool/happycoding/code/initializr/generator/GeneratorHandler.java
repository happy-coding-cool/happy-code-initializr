package cool.happycoding.code.initializr.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import cool.happycoding.code.initializr.dto.form.HappyCodeForm;
import cool.happycoding.code.initializr.generator.build.BuildGenerator;
import cool.happycoding.code.initializr.utils.GenerateUtils;
import freemarker.template.Configuration;

import java.io.File;

import static cool.happycoding.code.initializr.utils.GenerateUtils.ifNotExistsThenCreate;

/**
 * @ClassName GeneratorHandler
 * @Description 代码生成
 * @Author lanlanhappy
 * @Date 2020/12/30 8:27 下午
 */
public class GeneratorHandler {

    public static File generator(Configuration configuration, HappyCodeForm happyCodeForm){
        File file = ifNotExistsThenCreate(happyCodeForm.getProjectMetadata().getArtifact());
        GenerationConfiguration generationConfiguration
                = GenerationConfiguration.of(configuration, happyCodeForm);
        generationConfiguration.setZipFilePath(file.getAbsolutePath());
        new GeneratorChain()
                 // 生成readme
                .next(new MarkdownGenerator(generationConfiguration))
                 // build配置
                .next(new BuildGenerator(generationConfiguration))
                 // 生成.gitignore
                .next(new IgnoreGenerator(generationConfiguration))
                 // 生成 main app
                .next(new SrcMainGenerator(generationConfiguration))
                 // 生成 test
                .next(new SrcTestGenerator(generationConfiguration))
                .generator();

        // file 文件生成
        File zipFile =  ZipUtil.zip(new File(
                        happyCodeForm.getProjectMetadata().getArtifact() + ".zip"),
                true, file);
        FileUtil.del(file);
        return zipFile;
    }
}
