package cool.happycoding.code.initializr.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.initializr.dto.form.Database;

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

    public static boolean enableDatabase(Database database){
        return ObjectUtil.isNotNull(database) &&
                StrUtil.isNotBlank(database.getHost()) &&
                StrUtil.isNotBlank(database.getPort()) &&
                StrUtil.isNotBlank(database.getUsername()) &&
                StrUtil.isNotBlank(database.getSchema());
    }
}
