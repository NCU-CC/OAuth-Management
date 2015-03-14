package tw.edu.ncu.cc.manage.service;

import java.util.Map;

public interface IAuthService {
    String getLoginString();
    boolean isLoginSuccess(Map request);
    String getStudentId(Map request);
}
