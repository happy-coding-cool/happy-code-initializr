package cool.happycoding.code.initializr.generator.build;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.ZipUtil;
import cool.happycoding.code.initializr.generator.BaseGenerator;
import cool.happycoding.code.initializr.generator.GenerationConfig;
import lombok.SneakyThrows;

import java.io.File;
import java.util.zip.ZipInputStream;

import static cool.happycoding.code.initializr.generator.GeneratorPath.GenerateFile.BUILD_GRADLE_FILE;
import static cool.happycoding.code.initializr.generator.GeneratorPath.GenerateFile.SETTINGS_GRADLE_FILE;

/**
 * @ClassName GradleBuildGenerator
 * @Description Gradle配置生成
 * @Author lanlanhappy
 * @Date 2020/12/31 9:15 上午
 */
public class GradleBuildGenerator extends AbstractBuildGenerator {

    private final GenerationConfig generationConfig;

    public GradleBuildGenerator(GenerationConfig generationConfig) {
        this.generationConfig = generationConfig;
    }

    @SneakyThrows
    @Override
    public void generator() {

        // 复制 file目录下的文件到目标目录
        String gradlewPath = "/file/gradle/gradlew";
        String gradlewCmdPath = "/file/gradle/gradlew.bat";
        String wrapperPath = "/file/gradle/wrapper.zip";

        // 复制 gradlew gradlew.bat 文件
        copy(gradlewPath, generationConfig.getZipFilePath()+"/gradlew");
        copy(gradlewCmdPath, generationConfig.getZipFilePath()+"/gradlew.bat");

        // 生成.gradle 文件夹 复制 wrapper文件的内容
        File gradle = ifNotExistsThenCreate(generationConfig.getZipFilePath()+"/.gradle/");
        ZipUtil.unzip(new ZipInputStream(GradleBuildGenerator.class.getResourceAsStream(wrapperPath)),gradle);
        // 生成build.gradle/settings.gradle文件
        new BaseGenerator(generationConfig, BUILD_GRADLE_FILE).generator();
        new BaseGenerator(generationConfig, SETTINGS_GRADLE_FILE).generator();
    }
}
