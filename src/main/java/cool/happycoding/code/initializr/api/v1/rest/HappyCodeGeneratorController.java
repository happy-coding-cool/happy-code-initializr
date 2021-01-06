package cool.happycoding.code.initializr.api.v1.rest;

import com.google.common.collect.Lists;
import cool.happycoding.code.base.result.ListResult;
import cool.happycoding.code.initializr.api.v1.dto.TableDTO;
import cool.happycoding.code.initializr.api.v1.form.Database;
import cool.happycoding.code.initializr.api.v1.form.HappyCodeForm;
import freemarker.template.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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
        // TODO

    }

    /**
     * 预览
     * @param database
     * @return TableDTO
     */
    @PostMapping("tables")
    public ListResult<TableDTO> tables(@RequestBody Database database){

        return ListResult.success(Lists.newArrayList());

    }


}
