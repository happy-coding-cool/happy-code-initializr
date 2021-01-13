package cool.happycoding.code.initializr.generator;

import com.google.common.collect.Lists;
import cool.happycoding.code.initializr.base.Generator;

import java.util.List;

/**
 * @ClassName GeneratorChain
 * @Description TODO
 * @Author lanlanhappy
 * @Date 2021/01/13 8:26 上午
 */
public class GeneratorChain implements Generator {

    private List<Generator> generators;

    public GeneratorChain(){
        generators = Lists.newArrayList();
    }

    @Override
    public void generator() {
        generators.forEach(generator -> generator.generator());
    }

    public GeneratorChain next(Generator generator){
        generators.add(generator);
        return this;
    }
}
