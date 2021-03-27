package cool.happycoding.code.initializr.rest;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import cool.happycoding.code.base.exception.BizException;
import cool.happycoding.code.base.result.ListResult;
import cool.happycoding.code.initializr.dto.TableDto;
import cool.happycoding.code.initializr.dto.form.Database;
import cool.happycoding.code.initializr.dto.form.HappyCodeForm;
import cool.happycoding.code.initializr.generator.Config;
import cool.happycoding.code.initializr.generator.GeneratorHandler;
import freemarker.template.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

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
        } finally {
            // 删除文件
            FileUtil.del(zipFile);
        }
    }

    /**
     * 获取数据库的库表信息
     * @return
     */
    @PostMapping("tables")
    public ListResult<TableDto> tables(@RequestBody Database database){
        List<TableInfo> tableInfos = new ConfigBuilder(null,
                        new DataSourceConfig().setUrl(database.mysqlConn())
                        .setDriverName(Config.MYSQL_DRIVER)
                        .setUsername(database.getUsername())
                        .setPassword(database.getPassword()),
                        null,null, null).getTableInfoList();
        List<TableDto> tableDtos = tableInfos
                .stream()
                .map(tableInfo -> new TableDto(tableInfo.getName(), tableInfo.getComment()))
                .sorted()
                .collect(Collectors.toList());
        return ListResult.success(tableDtos);
    }

}
