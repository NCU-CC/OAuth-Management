package tw.edu.ncu.cc.manage.entity.oauth;

import org.apache.commons.lang3.StringUtils;

public class Application {

	private String id;
	private String name;
	private String description;
	private String url;
	private String callback;
	private String owner;
	private String secret;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = encode(name);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = encode(description);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	private static String encode(String input) {
		return StringUtils.replaceEach(input, new String[] { "&", "\"", "<", ">" }, new String[] { "&amp;", "&quot;", "&lt;", "&gt;" });
	}

	public boolean isOwner(String username) {
		return StringUtils.equals(username, this.owner);
	}
}
