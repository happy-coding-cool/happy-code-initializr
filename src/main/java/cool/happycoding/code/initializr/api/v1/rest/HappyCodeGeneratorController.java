package cool.happycoding.code.initializr.api.v1.rest;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cool.happycoding.code.base.exception.BizException;
import cool.happycoding.code.initializr.api.v1.form.HappyCodeForm;
import cool.happycoding.code.initializr.generator.GeneratorHandler;
import freemarker.template.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @ClassName HappyCodeGeneratorController
 * @Description happy-code 脚手架
 * @Author lanlanhappy
 * @Date 2020/12/27 12:34 下午
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("happy-code")
public class HappyCodeGeneratorController {

    private final Configuration configuration;

    /**
     * 生成zip包
     * @param happyCodeForm
     * @param response
     */
    @PostMapping("start")
    public void start(@RequestBody HappyCodeForm happyCodeForm, HttpServletResponse response){
        File zipFile = GeneratorHandler.generator(configuration, happyCodeForm);
        response.setContentType("application/zip");
        // 设置下载后的文件名 以及 header
        response.addHeader("Content-disposition",
                "attachment;fileName=" + happyCodeForm.getProjectMetadata().getArtifact() + ".zip");
        try {
            InputStream fis = new BufferedInputStream(new FileInputStream(zipFile));
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            IoUtil.copy(fis, toClient);
            toClient.close();
            fis.close();
        } catch (Exception e){
            throw new BizException("9999", e.getMessage());
        }finally {
            // 删除文件
            FileUtil.del(zipFile);
        }
    }

}
