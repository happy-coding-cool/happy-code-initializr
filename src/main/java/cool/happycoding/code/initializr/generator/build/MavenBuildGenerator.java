package cool.happycoding.code.initializr.generator.build;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.initializr.generator.BaseGenerator;
import cool.happycoding.code.initializr.generator.GenerationConfig;
import cool.happycoding.code.initializr.generator.Generator;
import lombok.SneakyThrows;
import org.springframework.util.ResourceUtils;

import java.io.File;

import static cool.happycoding.code.initializr.generator.GeneratorPath.GenerateFile.POM_FILE;

/**
 * @ClassName MavenBuildGenerator
 * @Description maven配置生成
 * @Author lanlanhappy
 * @Date 2020/12/31 9:14 上午
 */
public class MavenBuildGenerator implements Generator{

    private final GenerationConfig generationConfig;

    public MavenBuildGenerator(GenerationConfig generationConfig){
        this.generationConfig = generationConfig;
    }
    @SneakyThrows
    @Override
    public void generator() {
        // 复制 file目录下的文件到目标目录
        String mvnwPath = "classpath:file/mvn/mvnw";
        String mvnwCmdPath = "classpath:file/mvn/mvnw.cmd";
        String mvnWrapperPath = "classpath:file/mvn/wrapper";
        // 复制 mvnw mvn.cmd 文件
        FileUtil.copy(ResourceUtils.getFile(mvnwPath).getAbsolutePath(), generationConfig.getZipFilePath(), true);
        FileUtil.copy(ResourceUtils.getFile(mvnwCmdPath).getAbsolutePath(), generationConfig.getZipFilePath(), true);
        // 生成.mvn 文件夹 复制 wrapper文件的内容
        FileUtil.copyFilesFromDir(ResourceUtils.getFile(mvnWrapperPath),
                new File(StrUtil.concat(false,
                        generationConfig.getZipFilePath(),"/.mvn/wrapper")), true);
        // 生成pom文件
        new BaseGenerator(generationConfig, POM_FILE).generator();
    }
}
