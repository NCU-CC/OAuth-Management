package tw.edu.ncu.cc.manage.entity.oauth;

import java.util.List;

public class TokenInfo extends OAuthErrorMessage{
    private String id;
    private TokenClient client;
    private List<String> scope;
    private String lastUpdate;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public TokenClient getClient() {
        return client;
    }
    public void setClient(TokenClient client) {
        this.client = client;
    }
    public List<String> getScope() {
        return scope;
    }
    public void setScope(List<String> scope) {
        this.scope = scope;
    }
    public String getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
