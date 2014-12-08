package tw.edu.ncu.cc.manage.controller.login;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.manage.service.login.AuthService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class AuthController extends ActionSupport {

    private static final long serialVersionUID = 1L;
    @Autowired
    private HttpServletRequest request;  
    private AuthService authService; 
    private String student_id = "";

    @Override
    public String execute() throws Exception {
        student_id = checkOpenId();
        if (!isStringEmpty(student_id)) {     
                login(student_id);
                return SUCCESS;
        }
        return ERROR;
    }
    private boolean isStringEmpty(String string){
        return !(string!=null && string.length()>0);
    }
    private void login(String id){
        HttpSession session=request.getSession(true);
        session.setAttribute("tmpId", id);
    }

    private String checkOpenId() {
            boolean isChecked = authService.isLoginSuccess(request);
            if(isChecked){
                return authService.getIdentityId(request);
            }
        return null;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    @Inject
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

}
