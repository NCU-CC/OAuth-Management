package tw.edu.ncu.cc.manage.service;

import java.util.Map;

public interface AuthService {
    String getLoginString();
    boolean isLoginSuccess(Map request);
    String getStudentId(Map request);
}
