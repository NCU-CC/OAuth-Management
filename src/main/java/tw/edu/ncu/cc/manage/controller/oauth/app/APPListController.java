package tw.edu.ncu.cc.manage.controller.oauth.app;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.service.oauth.IAPPService;
import tw.edu.ncu.cc.manage.util.PersonUtil;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class APPListController extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private IAPPService service;
    private List<IdApplication> appList;    
    @Autowired
    private HttpServletRequest request;    

    @Override
    public String execute() throws Exception {  
        String userId = PersonUtil.getStudentId(request);
        appList =service.getAllAPPsByUserId(userId);
        return SUCCESS;
    }
    @Inject
    public void setService(IAPPService service) {
        this.service = service;
    }
    public List<IdApplication> getAppList() {
        return appList;
    }
    public void setAppList(List<IdApplication> appList) {
        this.appList = appList;
    }
}
