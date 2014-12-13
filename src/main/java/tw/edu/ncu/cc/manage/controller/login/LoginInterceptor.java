package tw.edu.ncu.cc.manage.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.manage.util.PersonInfo;
import tw.edu.ncu.cc.manage.util.PersonUtil;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@Controller
@Scope("request")
public class LoginInterceptor extends AbstractInterceptor{
    private static final long serialVersionUID = 1L;
    @Autowired
    private HttpServletRequest request;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        request = ServletActionContext.getRequest();
        PersonInfo personInfo=PersonUtil.getPersonInfo(request);
        if(personInfo!=null){
            String tmpId=personInfo.getAccount();
            if(tmpId!=null && tmpId.length()>0){           
                    return invocation.invoke();
            }
        }
        return Action.LOGIN;
    }

}
