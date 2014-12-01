package tw.edu.ncu.cc.manage.service.login;

import java.util.Map;

import javax.inject.Inject;

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

    @SuppressWarnings("rawtypes")
    public boolean isLoginSuccess(Map request) {
        return openIDManager.checkAuthentication(request);
    }

    @SuppressWarnings("rawtypes")
    public String getStudentId(Map request) {
        return openIDManager.getStudentID(request);
    }

}
