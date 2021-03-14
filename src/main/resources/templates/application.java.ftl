package ${projectMetadata.proPackage};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author ${author.email}
 * @since ${date}
 */
@SpringBootApplication
public class ${artifactToCamelCase}Application {
    public static void main(String[] args) {
        SpringApplication.run(${artifactToCamelCase}Application.class, args);
    }
}
