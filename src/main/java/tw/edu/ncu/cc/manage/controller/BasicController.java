package tw.edu.ncu.cc.manage.controller;

import java.util.Map;

import org.apache.struts2.util.TokenHelper;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class BasicController{
    private static final long serialVersionUID = 1L;
    private String errorTitle;
    private String errorContent;    
    private String token;
    private int errorType=0;
    public String getErrorTitle() {
        return errorTitle;
    }
    public void setErrorTitle(String errorTitle) {
        this.errorTitle = errorTitle;
    }
    public String getErrorContent() {
        return errorContent;
    }
    public void setErrorContent(String errorContent) {
        this.errorContent = errorContent;
    }
    public int getErrorType() {
        return errorType;
    }
    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }
    public void setErrorMessage(String title,String content){
        this.setErrorTitle(title);
        this.setErrorContent(content);
    }

    public String getToken() {
      return token;
    }

    public void setToken(String token) {
      this.token = token;
    }

    protected void createTokenForGet() {
      Map<String, Object> context = ActionContext.getContext().getValueStack().getContext();
      Object myToken = context.get("token");
      if (myToken == null) {
          myToken = TokenHelper.setToken("token");
          context.put("token", myToken);
      }
      token = myToken.toString();
    }
    
}
