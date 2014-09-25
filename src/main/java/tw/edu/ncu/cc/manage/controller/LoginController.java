package tw.edu.ncu.cc.manage.controller;

import javax.inject.Inject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tw.edu.ncu.cc.manage.service.AuthService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class LoginController extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private String loginUrl;
    private AuthService authService; 
    
    @Inject
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public String execute() {
           this.loginUrl=authService.getLoginString();
           if(this.loginUrl!=null && !this.loginUrl.equals("")){
               return SUCCESS;
           }
           return ERROR;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }    
}
