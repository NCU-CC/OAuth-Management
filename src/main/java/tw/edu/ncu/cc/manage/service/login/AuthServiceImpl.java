package tw.edu.ncu.cc.manage.service.login;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.openid.OpenIDManager;

@Service
public class AuthServiceImpl implements AuthService{

    OpenIDManager openIDManager;
    
    @Inject
    public void setOpenIDManager(OpenIDManager openIDManager) {
        this.openIDManager = openIDManager;
    }

    public String getLoginString() {
        return openIDManager.getURLString();
    }

    public boolean isLoginSuccess(HttpServletRequest request) {
        return openIDManager.checkAuthentication(request);
    }

    public String getIdentityId(HttpServletRequest request) {
        return openIDManager.getIdentityID(request);
    }

}
