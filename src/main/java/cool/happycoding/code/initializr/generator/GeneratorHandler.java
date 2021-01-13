package cool.happycoding.code.initializr.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import cool.happycoding.code.initializr.api.v1.form.HappyCodeForm;
import cool.happycoding.code.initializr.base.BaseGenerationConfiguration;
import cool.happycoding.code.initializr.base.BaseGenerator;
import cool.happycoding.code.initializr.generator.build.maven.MavenBuildGenerationConfiguration;
import cool.happycoding.code.initializr.generator.build.maven.MavenBuildGenerator;
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
        // file 文件生成
        new GeneratorChain()
                .next(new BaseGenerator(BaseGenerationConfiguration.of(configuration, happyCodeForm)))
                .next(new MavenBuildGenerator(MavenBuildGenerationConfiguration.of(configuration, happyCodeForm)))
                .generator();
        File zipFile = ZipUtil.zip(new File(
                        happyCodeForm.getProjectMetadata().getArtifact() + ".zip"),
                true, file);
        return zipFile;
    }
}
