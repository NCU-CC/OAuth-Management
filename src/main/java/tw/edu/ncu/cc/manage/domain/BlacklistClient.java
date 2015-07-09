package tw.edu.ncu.cc.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BlacklistClient {

	private String client_id;

	private String reason;
	
	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
