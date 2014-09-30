package tw.edu.ncu.cc.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.manage.openid.OpenIDException;
import tw.edu.ncu.cc.manage.openid.OpenIDManager;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class AuthController extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private HttpServletRequest request;
    private String student_id = "";

    @Override
    public String execute() throws Exception {
        request = ServletActionContext.getRequest();
        student_id = request.getParameter("openid.ext1.value.student_id");
        if (student_id != null && student_id.trim().length() > 0) {
            if (checkOpenId()) {          
                login(student_id);
                return SUCCESS;
            }
        }
        return ERROR;
    }
    
    private void login(String id){
        HttpSession session=request.getSession(true);
        session.setAttribute("tmpId", id);
    }

    private boolean checkOpenId() {
        try {
            OpenIDManager manager = new OpenIDManager();
            return manager.checkAuthentication(ServletActionContext
                    .getRequest().getParameterMap());
        } catch (OpenIDException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

}
