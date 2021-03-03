package cool.happycoding.code.initializr.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import cool.happycoding.code.initializr.dto.form.HappyCodeForm;
import cool.happycoding.code.initializr.generator.build.MavenBuildGenerator;
import freemarker.template.Configuration;

import java.io.File;

/**
 * @ClassName GeneratorHandler
 * @Description 代码生成
 * @Author lanlanhappy
 * @Date 2020/12/30 8:27 下午
 */
public class GeneratorHandler {

    public static File generator(Configuration configuration, HappyCodeForm happyCodeForm){
        File file = new File(happyCodeForm.getProjectMetadata().getArtifact());
        if (file.exists()) {
            FileUtil.del(file);
        }
        FileUtil.mkdir(file);
        GenerationConfiguration generationConfiguration
                = GenerationConfiguration.of(configuration, happyCodeForm);
        generationConfiguration.setZipFilePath(file.getAbsolutePath());
        new GeneratorChain()
                 // 生成readme
                .next(new ReadMeGenerator(generationConfiguration))
                 // 生成pom.xml
                .next(new MavenBuildGenerator(generationConfiguration))
                 // 生成 main app
                .next(new SrcMainGenerator(generationConfiguration))
                 // 生成 test
                .next(new SrcTestGenerator(generationConfiguration))
                .generator();
        // file 文件生成
        File zipFile = ZipUtil.zip(new File(
                        happyCodeForm.getProjectMetadata().getArtifact() + ".zip"),
                true, file);
        return zipFile;
    }
}
