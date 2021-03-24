package cool.happycoding.code.initializr.generator.build;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.initializr.generator.BaseGenerator;
import cool.happycoding.code.initializr.generator.GenerationConfig;
import cool.happycoding.code.initializr.generator.Generator;
import lombok.SneakyThrows;
import org.springframework.util.ResourceUtils;

import java.io.File;

import static cool.happycoding.code.initializr.generator.GeneratorPath.GenerateFile.*;

/**
 * @ClassName GradleBuildGenerator
 * @Description Gradle配置生成
 * @Author lanlanhappy
 * @Date 2020/12/31 9:15 上午
 */
public class GradleBuildGenerator implements Generator {

    private final GenerationConfig generationConfig;

    public GradleBuildGenerator(GenerationConfig generationConfig) {
        this.generationConfig = generationConfig;
    }

    @SneakyThrows
    @Override
    public void generator() {
        // 复制 file目录下的文件到目标目录
        String gradlewPath = "classpath:file/gradle/gradlew";
        String gradlewCmdPath = "classpath:file/gradle/gradlew.bat";
        String gradleWrapperPath = "classpath:file/gradle/wrapper";
        // 复制 gradlew gradlew.bat 文件
        FileUtil.copy(ResourceUtils.getFile(gradlewPath).getAbsolutePath(), generationConfig.getZipFilePath(), true);
        FileUtil.copy(ResourceUtils.getFile(gradlewCmdPath).getAbsolutePath(), generationConfig.getZipFilePath(), true);
        // 生成.gradle 文件夹 复制 wrapper文件的内容
        FileUtil.copyFilesFromDir(ResourceUtils.getFile(gradleWrapperPath),
                new File(StrUtil.concat(false,
                        generationConfig.getZipFilePath(),"/.gradle/wrapper")), true);
        // 生成build.gradle/settings.gradle文件
        new BaseGenerator(generationConfig, BUILD_GRADLE_FILE).generator();
        new BaseGenerator(generationConfig, SETTINGS_GRADLE_FILE).generator();
    }
}
