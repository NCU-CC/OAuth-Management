package tw.edu.ncu.cc.manage.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.manage.openid.OpenIDException;
import tw.edu.ncu.cc.manage.openid.OpenIDManager;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class AuthController extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private HttpServletRequest request;

    @Override
    public String execute() throws Exception {
        request = ServletActionContext.getRequest();
        String student_id = request.getParameter("openid.ext1.value.student_id");
        if (student_id != null && student_id.length() > 0) {
            if (checkOpenId()) {
                return SUCCESS;
            }
        }
        return ERROR;
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
}
