package tw.edu.ncu.cc.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "index", "default"})
public class MainController{
    private static final long serialVersionUID = 1L;

    public String execute() throws Exception {                
        return "index";
    }
}
