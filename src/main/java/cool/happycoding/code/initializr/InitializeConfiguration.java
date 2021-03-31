package cool.happycoding.code.initializr;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

/**
 * <p>InitializeConfiguration.java</P>
 *
 * @author lanlanhappy
 * @date 2021/01/18 8:32 上午
 */
@Configuration
public class InitializeConfiguration {

    @Bean
    @SneakyThrows
    public freemarker.template.Configuration configuration() {
        freemarker.template.Configuration configuration =
                new freemarker.template.Configuration(freemarker.template.Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
        configuration.setClassForTemplateLoading(InitializeConfiguration.class, StringPool.SLASH);
        return configuration;
    }
}
