package tw.edu.ncu.cc.manage.controller;

import com.opensymphony.xwork2.ActionSupport;

public class BasicController extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private String errorTitle;
    private String errorContent;
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
    
}
