package tw.edu.ncu.cc.manage.controller.oauth.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
@Controller
@Scope("prototype")
public class APPInterceptor extends AbstractInterceptor{
    private static final long serialVersionUID = 1L;
    @Autowired
    private HttpServletRequest request;
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {        
        return invocation.invoke();
    }

}
