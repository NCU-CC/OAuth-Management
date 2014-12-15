package tw.edu.ncu.cc.manage.controller.oauth.app;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tw.edu.ncu.cc.manage.controller.BasicController;
import tw.edu.ncu.cc.manage.entity.oauth.OAuthErrorMessage;
import tw.edu.ncu.cc.manage.entity.oauth.application.Application;
import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;
import tw.edu.ncu.cc.manage.service.oauth.IAPPService;
import tw.edu.ncu.cc.manage.service.oauth.exception.OAuthConnectionException;
import tw.edu.ncu.cc.manage.util.PersonUtil;

@Component
@Scope("prototype")
public class APPEditController extends BasicController {
    private static final long serialVersionUID = 1L;
    private IAPPService service;
    private String id;
    private IdApplication appInfo;
    private boolean isAccessible;
    @Autowired
    private HttpServletRequest request;    
    
    private String warningTitle;
    private String warningContent;

    @Override
    public String execute() throws Exception {  
        appInfo =getAPPbyAPPId(id);
        if(isAccessible){           
            createTokenForGet();
            return INPUT;
        }
        return ERROR;        
    }    
    
    public String upload(){
        IdApplication old = getAPPbyAPPId(id);
        if(isAccessible){    
            appInfo=copyAPPInfo(appInfo,old);
            try {
                Application app = service.updateAPP(appInfo);
                if(app==null){
                    warningTitle = "有些錯誤";
                    warningContent = "處理有些錯誤";
                    return INPUT;
                }
            } catch (OAuthConnectionException e) {
                warningTitle = "有些錯誤";
                warningContent = "處理有些錯誤";
                OAuthErrorMessage errorMessage = e.getAuthErrorMessage();
                if(errorMessage!=null){
                    setErrorMessage("發生錯誤", errorMessage.getError_description());
                }    
                return INPUT;
            }            
            return SUCCESS;
        }
        return ERROR;     
    }
    
    public String delete(){
        getAPPbyAPPId(id);
        if(isAccessible){ 
            Application app=service.removeAPP(id);
            if(app==null){
                warningTitle = "有些錯誤";
                warningContent = "處理有些錯誤";
                return INPUT;
            }
            return SUCCESS;
        }
        return ERROR;   
    }
    
    private IdApplication getAPPbyAPPId(String id){
        String userId = PersonUtil.getStudentId(request);
        IdApplication appInfo=service.getAPPbyAPPId(id);
        if(appInfo==null){
            setErrorMessage("找無此APP", "無法找到該APP，可以是因為已被刪除");
        }else if(!service.isAllowToAccess(appInfo, userId)){
            setErrorMessage("您無權限存取該APP", "您無權限存取該APP，您並非是此APP的傭有者");
        }else{
            isAccessible=true;
            return appInfo;
        }
        isAccessible=false;
        return null;
    }
    private IdApplication copyAPPInfo(IdApplication main,IdApplication old){
        main.setId(old.getId());
        main.setOwner(old.getOwner());
        return main;
    }
    
    @Inject
    public void setService(IAPPService service) {
        this.service = service;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public IdApplication getAppInfo() {
        return appInfo;
    }
    public void setAppInfo(IdApplication appInfo) {
        this.appInfo = appInfo;
    }
    public String getWarningTitle() {
        return warningTitle;
    }
    public void setWarningTitle(String warningTitle) {
        this.warningTitle = warningTitle;
    }
    public String getWarningContent() {
        return warningContent;
    }
    public void setWarningContent(String warningContent) {
        this.warningContent = warningContent;
    }

}
