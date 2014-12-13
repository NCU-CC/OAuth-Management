package tw.edu.ncu.cc.manage.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("request")
public class LogoutController extends ActionSupport {

    private static final long serialVersionUID = 1L;
    @Autowired
    private HttpServletRequest request; 
    @Override
    public String execute() throws Exception {
        HttpSession session=request.getSession(true);
        session.invalidate();
        session=request.getSession(true);
        return SUCCESS;        
    }
}
