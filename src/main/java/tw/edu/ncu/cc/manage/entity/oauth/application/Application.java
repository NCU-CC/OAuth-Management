package tw.edu.ncu.cc.manage.entity.oauth.application;

import tw.edu.ncu.cc.manage.util.StringOperator;

public class Application {

    private String name;
    private String description;
    private String url;
    private String callback;
    private String owner;

    public String getName() {        
        return name;
    }

    public void setName( String name ) {
        this.name = StringOperator.getEncodeString(name);
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = StringOperator.getEncodeString(description);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl( String url ) {
        this.url = url;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback( String callback ) {
        this.callback = callback;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner( String owner ) {
        this.owner = owner;
    }

}
