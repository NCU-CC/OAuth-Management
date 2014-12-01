package tw.edu.ncu.cc.manage.entity.oauth;

public class APPInfo extends OAuthErrorMessage{
    private String id;
    private String secret;
    private String name;
    private String description;
    private String appURL;
    private String callback;
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
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAppURL() {
        return appURL;
    }
    public void setAppURL(String appURL) {
        this.appURL = appURL;
    }
    public String getCallback() {
        return callback;
    }
    public void setCallback(String callback) {
        this.callback = callback;
    }
}
