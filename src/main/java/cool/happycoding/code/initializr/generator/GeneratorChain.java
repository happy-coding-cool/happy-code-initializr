package cool.happycoding.code.initializr.generator;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @ClassName GeneratorChain
 * @Description TODO
 * @Author lanlanhappy
 * @Date 2021/01/13 8:26 上午
 */
public class GeneratorChain implements Generator {

    private final List<Generator> generators;

    public GeneratorChain(){
        generators = Lists.newArrayList();
    }

    @Override
    public void generator() {
      generators.forEach(Generator::generator);
    }

    public GeneratorChain next(Generator generator){
        generators.add(generator);
        return this;
    }
}
