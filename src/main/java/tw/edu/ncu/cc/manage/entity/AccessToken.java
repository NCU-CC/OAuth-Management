package tw.edu.ncu.cc.manage.entity;

import java.util.Date;

import org.springframework.util.StringUtils;

import tw.edu.ncu.cc.manage.entity.oauth.Application;


public class AccessToken {

	private String id;
	private String user;
	private Application application;
	private String[] scope;
	private Date last_updated;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public String[] getScope() {
		return scope;
	}

	public void setScope(String[] scope) {
		this.scope = scope;
	}

	public Date getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}

	public String getScopeString() {
		return StringUtils.arrayToDelimitedString(scope, " ");
	}
}
