package tw.edu.ncu.cc.manage.service.impl;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.openid.OpenIDManager;
import tw.edu.ncu.cc.manage.service.IAuthService;


@Service
public class AuthService implements IAuthService {

	OpenIDManager openIDManager;

	@Inject
	public void setOpenIDManager(OpenIDManager openIDManager) {
		this.openIDManager = openIDManager;
	}

	public String getLoginString() {
		return openIDManager.getURLString();
	}

	public boolean isLoginSuccess(Map request) {
		return openIDManager.checkAuthentication(request);
	}

	public String getStudentId(Map request) {
		return openIDManager.getStudentID(request);
	}

}
