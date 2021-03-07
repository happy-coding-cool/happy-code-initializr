package cool.happycoding.code.initializr.generator.build;

import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.initializr.generator.GenerationConfiguration;
import cool.happycoding.code.initializr.generator.Generator;

/**
 * <p>BuildGenerator.java</P>
 *
 * @author lanlanhappy
 * @date 2021/03/07 7:56 下午
 */
public class BuildGenerator implements Generator {

    private final Generator generator;
    private static final String GRADLE_BUILD = "gradle";

    public BuildGenerator(GenerationConfiguration generationConfiguration){
        this.generator = build(generationConfiguration);
    }

    @Override
    public void generator() {
        generator.generator();
    }

    private Generator build(GenerationConfiguration generationConfiguration){
        if (StrUtil.equalsAnyIgnoreCase(GRADLE_BUILD, generationConfiguration.getHappyCodeForm().getBuild())){
            return new GradleBuildGenerator(generationConfiguration);
        }else{
            return new MavenBuildGenerator(generationConfiguration);
        }
    }

}
