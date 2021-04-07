package ${projectMetadata.proPackage};
<#if enableMybatisPlus>
import org.mybatis.spring.annotation.MapperScan;
</#if>
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
<#if enableMybatisPlus>
@MapperScan("${projectMetadata.proPackage}.**.mapper")
</#if>
public class ${artifactToCamelCase}Application {
    public static void main(String[] args) {
        SpringApplication.run(${artifactToCamelCase}Application.class, args);
    }
}
