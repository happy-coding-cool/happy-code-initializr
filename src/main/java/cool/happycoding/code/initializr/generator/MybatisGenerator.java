package cool.happycoding.code.initializr.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;

/**
 * <p>MybatisGenerator.java</P>
 *
 * @author lanlanhappy
 * @date 2021/03/08 9:25 下午
 */
public class MybatisGenerator implements Generator{

    private final AutoGenerator autoGenerator;

    public MybatisGenerator(GenerationConfiguration generationConfiguration){
        this.autoGenerator = build(generationConfiguration);
    }

    private AutoGenerator build(GenerationConfiguration generationConfiguration) {
        // TODO 构造config
        return new AutoGenerator();
    }


    @Override
    public void generator() {
        autoGenerator.execute();
    }
}
