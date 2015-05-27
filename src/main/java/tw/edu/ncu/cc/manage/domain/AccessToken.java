package tw.edu.ncu.cc.manage.domain;

import java.sql.Timestamp;

import org.springframework.util.StringUtils;

public class AccessToken {

	private String id;
	private String user;
	private String[] scope;
	private Timestamp last_updated;

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

	public String[] getScope() {
		return scope;
	}

	public void setScope(String[] scope) {
		this.scope = scope;
	}

	public Timestamp getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(Timestamp last_updated) {
		this.last_updated = last_updated;
	}

	public String getScopeString() {
		return StringUtils.arrayToDelimitedString(scope, " ");
	}
}
