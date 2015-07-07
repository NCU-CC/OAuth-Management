package tw.edu.ncu.cc.manage.domain;

public class BlacklistClient {

	private Client client;
	
	private String reason;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
