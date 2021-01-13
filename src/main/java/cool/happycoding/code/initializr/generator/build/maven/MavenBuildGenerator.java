package cool.happycoding.code.initializr.generator.build.maven;

import cool.happycoding.code.initializr.base.BaseGenerationConfiguration;
import cool.happycoding.code.initializr.base.Generator;

/**
 * @ClassName MavenBuildGenerator
 * @Description maven配置生成
 * @Author lanlanhappy
 * @Date 2020/12/31 9:14 上午
 */
public class MavenBuildGenerator implements Generator{


    private final MavenBuildGenerationConfiguration mavenBuildGenerationConfiguration;

    public MavenBuildGenerator(MavenBuildGenerationConfiguration mavenBuildGenerationConfiguration){
        this.mavenBuildGenerationConfiguration = mavenBuildGenerationConfiguration;
    }


    @Override
    public void generator() {

    }
}
