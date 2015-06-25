package tw.edu.ncu.cc.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ApiToken {
	
	private String id;

	private String token;

	private String client_id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
