package tw.edu.ncu.cc.manage.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MainpageController extends BasicController {
    private static final long serialVersionUID = 1L;

    public String execute() throws Exception {                
        return SUCCESS;
    }
}
