package tw.edu.ncu.cc.manage.entity.oauth;

public class OAuthErrorMessage {
    private String code;
    private String message;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public boolean isError(){
        if(code==null || code.length() == 0){
            return true;
        }
        return false;
    }
}
