package tw.edu.ncu.cc.manage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class MainpageController extends ActionSupport {

    private static final long serialVersionUID = 1L;
    @Autowired
    private HttpServletRequest request;    

    @Override
    public String execute() throws Exception {                
        return SUCCESS;
    }
}
