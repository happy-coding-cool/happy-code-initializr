package cool.happycoding.code.initializr.generator.build;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cool.happycoding.code.initializr.generator.Generator;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;

/**
 * <p>AbstractBuildGenerator.java</P>
 *
 * @author lanlanhappy
 * @date 2021/03/31 8:30 上午
 */
public abstract class AbstractBuildGenerator implements Generator {

    @SneakyThrows
    protected void copy(String path, String dest){
        FileOutputStream fos = new FileOutputStream(dest);
        IoUtil.copy(AbstractBuildGenerator.class.getResourceAsStream(path), fos);
        fos.flush();
        fos.close();
    }

    protected static File ifNotExistsThenCreate(String filePath){
        File tempFile = new File(filePath);
        if (tempFile.exists()) {
            FileUtil.del(tempFile);
        }
        FileUtil.mkdir(tempFile);
        return tempFile;
    }
}
