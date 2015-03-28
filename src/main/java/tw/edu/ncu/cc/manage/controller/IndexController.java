package tw.edu.ncu.cc.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private static final long serialVersionUID = 1L;

    @RequestMapping({"/", "index", "default"})
    public String index() {                
        return "index";
    }
}
