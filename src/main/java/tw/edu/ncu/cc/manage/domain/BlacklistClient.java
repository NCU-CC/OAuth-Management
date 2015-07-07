package tw.edu.ncu.cc.manage.domain;

import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlacklistClient {

	private Client client;

	private String reason;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@JsonProperty("client_id")
	public String getClientId() {
		
		if (Objects.nonNull(client)) {
			return this.client.getId();
		}
		
		return "";
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
