package tw.edu.ncu.cc.manage.service.login;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {
    String getLoginString();
    boolean isLoginSuccess(HttpServletRequest request);
    public String getIdentityId(HttpServletRequest request);
}
