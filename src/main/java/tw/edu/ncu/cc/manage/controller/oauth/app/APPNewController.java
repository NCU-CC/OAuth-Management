package tw.edu.ncu.cc.manage.controller.oauth.app;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.manage.controller.BasicController;
import tw.edu.ncu.cc.manage.entity.oauth.OAuthErrorMessage;
import tw.edu.ncu.cc.manage.entity.oauth.application.Application;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.entity.oauth.application.SecretIdApplication;
import tw.edu.ncu.cc.manage.service.oauth.IAPPService;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;
import tw.edu.ncu.cc.manage.util.PersonUtil;

@Controller
@Scope("request")
public class APPNewController extends BasicController {
    private static final long serialVersionUID = 1L;
    private IAPPService service;
    private Application appInfo;
    private SecretIdApplication appInfoid;
    private boolean isAccessible;
    private String id;
    @Autowired
    private HttpServletRequest request;    

    @Override
    public String execute() throws Exception {
        return INPUT;
    }
    
    public String create(){
        appInfo.setOwner(PersonUtil.getStudentId(request));
        try {
            appInfoid = service.createAPP(appInfo);
            if(appInfoid!=null){
                return SUCCESS;
            }
            setDefaultError();
        } catch (OAuthConnectionException e) {
            OAuthErrorMessage errorMessage = e.getAuthErrorMessage();
            if(errorMessage!=null){
                setErrorMessage("發生錯誤", errorMessage.getError_description());
            }            
        }        
        return INPUT;
    }
    
    public String update(){
        getAPPbyAPPId(id);
        if(isAccessible){ 
            appInfoid=service.newSecret(id);
            if(appInfoid==null){
                return INPUT;
            }
            return SUCCESS;
        }
        return INPUT;
    }
    
    private IdApplication getAPPbyAPPId(String id) {
        String userId = PersonUtil.getStudentId(request);
        IdApplication appInfo = service.getAPPbyAPPId(id);
        if (appInfo == null) {
            setErrorMessage("找無此APP", "無法找到該APP，可以是因為已被刪除");
        } else if (!service.isAllowToAccess(appInfo, userId)) {
            setErrorMessage("您無權限存取該APP", "您無權限存取該APP，您並非是此APP的傭有者");
        } else {
            isAccessible = true;
            return appInfo;
        }
        isAccessible = false;
        return null;
    }
          
    private void setDefaultError(){
        setErrorMessage("未知原因", "請稍後在試");
    }
    @Inject
    public void setService(IAPPService service) {
        this.service = service;
    }

    public Application getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(Application appInfo) {
        this.appInfo = appInfo;
    }

    public SecretIdApplication getAppInfoid() {
        return appInfoid;
    }

    public void setAppInfoid(SecretIdApplication appInfoid) {
        this.appInfoid = appInfoid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
