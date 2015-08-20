package tw.edu.ncu.cc.manage.domain;

import java.sql.Timestamp;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.StringUtils;

public class AuthorizedToken {

	private String id;
	private String user;
	private String[] scope;
	private Timestamp last_updated;
	private Client client;
	
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
		
		scope = ArrayUtils.nullToEmpty(scope);
		
		for (int i = 0; i < scope.length; i++) {
			String str = scope[i];
			if (StringUtils.hasText(str)) {
				scope[i] = str.toUpperCase();
			}
		}
		
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
