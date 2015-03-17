package tw.edu.ncu.cc.manage.controller.oauth.app;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
@Component
@Scope("prototype")
public class APPInterceptor extends AbstractInterceptor{
    private static final long serialVersionUID = 1L;
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {        
        return invocation.invoke();
    }

}
