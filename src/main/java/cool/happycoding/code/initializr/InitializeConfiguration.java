package cool.happycoding.code.initializr;

import cn.hutool.core.util.StrUtil;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
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
        configuration.setDirectoryForTemplateLoading(new File(
                StrUtil.concat(false,
                        InitializeConfiguration.class.getResource("/").toURI().getPath(),
                        "/templates/")
        ));
        return configuration;
    }
}
