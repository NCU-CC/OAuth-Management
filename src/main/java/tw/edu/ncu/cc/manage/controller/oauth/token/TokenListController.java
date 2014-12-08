package tw.edu.ncu.cc.manage.controller.oauth.token;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.manage.controller.BasicController;
import tw.edu.ncu.cc.manage.entity.oauth.token.AccessToken;
import tw.edu.ncu.cc.manage.service.oauth.ITokenService;
import tw.edu.ncu.cc.manage.util.PersonUtil;


@Controller
@Scope("prototype")
public class TokenListController extends BasicController {
    private static final long serialVersionUID = 1L;
    @Autowired
    private HttpServletRequest request;
    private ITokenService service;
    private String id;
    private boolean isAccessible;
    private List<AccessToken> tokenList;

    @Override
    public String execute() throws Exception {                
        String userId = PersonUtil.getStudentId(request);
        tokenList =service.getAllTokensByUserId(userId);
        return SUCCESS;
    }
    public String remove(){
        getTokenbyTokenId(id);
        if(isAccessible){ 
            AccessToken appInfo=service.removeToken(id);
            if(appInfo==null){
                return INPUT;
            }
            return SUCCESS;
        }
        return INPUT;
    }
    
    private AccessToken getTokenbyTokenId(String id) {
        String userId = PersonUtil.getStudentId(request);
        AccessToken appInfo = service.getTokenbyTokenId(id);
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
    @Inject
    public void setService(ITokenService service) {
        this.service = service;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<AccessToken> getTokenList() {
        return tokenList;
    }
    public void setTokenList(List<AccessToken> tokenList) {
        this.tokenList = tokenList;
    }
}
