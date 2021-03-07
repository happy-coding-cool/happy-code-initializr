package cool.happycoding.code.initializr.utils;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * <p>GenerateUtils.java</P>
 *
 * @author lanlanhappy
 * @date 2021/03/07 8:03 下午
 */
public final class GenerateUtils {

    /**
     * 判断文件是否存在，不存在则创建
     * @param filePath
     * @return
     */
    public static File ifNotExistsThenCreate(String filePath){
        File tempFile = new File(filePath);
        if (tempFile.exists()) {
            FileUtil.del(tempFile);
        }
        FileUtil.mkdir(tempFile);
        return tempFile;
    }
}
