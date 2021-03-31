package cool.happycoding.code.initializr.generator.build;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.ZipUtil;
import cool.happycoding.code.initializr.generator.BaseGenerator;
import cool.happycoding.code.initializr.generator.GenerationConfig;
import lombok.SneakyThrows;

import java.io.File;
import java.util.zip.ZipInputStream;

import static cool.happycoding.code.initializr.generator.GeneratorPath.GenerateFile.POM_FILE;

/**
 * @ClassName MavenBuildGenerator
 * @Description maven配置生成
 * @Author lanlanhappy
 * @Date 2020/12/31 9:14 上午
 */
public class MavenBuildGenerator extends AbstractBuildGenerator{

    private final GenerationConfig generationConfig;

    public MavenBuildGenerator(GenerationConfig generationConfig){
        this.generationConfig = generationConfig;
    }
    @SneakyThrows
    @Override
    public void generator() {
        // 复制 file目录下的文件到目标目录
        String mvnwPath = "file:file/mvn/mvnw";
        String mvnwCmdPath = "file:file/mvn/mvnw.cmd";
        String wrapperPath = "file:file/mvn/wrapper.zip";
        // 复制 mvnw mvn.cmd 文件
        copy(mvnwPath, generationConfig.getZipFilePath()+"/mvnw");
        copy(mvnwCmdPath, generationConfig.getZipFilePath()+"/mvnw.cmd");
        // 生成.mvn文件夹
        ZipUtil.unzip(new ZipInputStream(ResourceUtil.getStream(wrapperPath)),
                new File(generationConfig.getZipFilePath()+"/.mvn/"));
        // 生成pom文件
        new BaseGenerator(generationConfig, POM_FILE).generator();
    }
}
