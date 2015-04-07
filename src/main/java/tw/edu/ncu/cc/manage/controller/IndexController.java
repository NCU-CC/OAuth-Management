package tw.edu.ncu.cc.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首頁
 * @author yyc1217
 *
 */
@Controller
public class IndexController {

    @RequestMapping({"/", "/index", "/default"})
    public String index() {                
        return "index";
    }
}
