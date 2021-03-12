package cool.happycoding.code.initializr.generator.build;

import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.initializr.generator.GenerationConfig;
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

    public BuildGenerator(GenerationConfig generationConfig){
        this.generator = build(generationConfig);
    }

    @Override
    public void generator() {
        generator.generator();
    }

    private Generator build(GenerationConfig generationConfig){
        if (StrUtil.equalsAnyIgnoreCase(GRADLE_BUILD, generationConfig.getHappyCodeForm().getBuild())){
            return new GradleBuildGenerator(generationConfig);
        }else{
            return new MavenBuildGenerator(generationConfig);
        }
    }

}
