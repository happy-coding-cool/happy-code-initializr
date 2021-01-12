package ${projectMetadata.proPackage};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ${artifactToCamelCase}Application {
    public static void main(String[] args) {
        SpringApplication.run(${artifactToCamelCase}Application.class, args);
    }
}
