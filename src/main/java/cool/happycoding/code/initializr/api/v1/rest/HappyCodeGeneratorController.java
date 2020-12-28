package cool.happycoding.code.initializr.api.v1.rest;

import cool.happycoding.code.initializr.api.v1.form.HappyCodeForm;
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
@RequestMapping("happy-code")
public class HappyCodeGeneratorController {


    @PostMapping("start")
    public void start(@RequestBody HappyCodeForm happyCodeForm, HttpServletResponse response){

        // TODO

    }
}
