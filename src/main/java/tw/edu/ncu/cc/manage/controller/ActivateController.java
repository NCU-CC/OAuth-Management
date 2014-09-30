package tw.edu.ncu.cc.manage.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.IPersonService;
import tw.edu.ncu.cc.manage.util.PersonInfo;
import tw.edu.ncu.cc.manage.util.PersonUtil;
import tw.edu.ncu.cc.manage.util.SignVersion;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ActivateController extends ActionSupport {
    private static final long serialVersionUID = 1L;    
    private HttpServletRequest request;
    private IPersonService<Person> service;
    
    private String signText;
    private String updateDate;
    private int singVersion;
    
    private int userSignVersion;
    private String userSignDate;
    
    public int getUserSignVersion() {
        return userSignVersion;
    }

    public void setUserSignVersion(int userSignVersion) {
        this.userSignVersion = userSignVersion;
    }

    public String getUserSignDate() {
        return userSignDate;
    }

    public void setUserSignDate(String userSignDate) {
        this.userSignDate = userSignDate;
    }

    public int getSingVersion() {
        return singVersion;
    }

    public void setSingVersion(int singVersion) {
        this.singVersion = singVersion;
    }

    @Inject
    public void setService(IPersonService<Person> service) {
        this.service = service;
    }
    
    @Override
    public String execute() throws Exception {
        request=ServletActionContext.getRequest();
        PersonInfo personInfo=PersonUtil.getPersonInfo(request);
        String tmpId=personInfo.getAccount();
        if(tmpId!=null && tmpId.length()>0){
            Person person=service.findPersonByAccount(tmpId);
            if(person!=null){
                int version=person.getSign_version();
                if(version < SignVersion.version){
                    Date date=person.getSign_date();
                    if(date!=null){
                        userSignDate=date.toString();
                    }
                    userSignVersion=person.getSign_version();
                    
                    signText=SignVersion.signContent;
                    updateDate=SignVersion.updateDate;
                    singVersion=SignVersion.version;
                    return INPUT;
                }else{
                    return SUCCESS;
                }
            }
        }                        
        return LOGIN;
    }
    public String getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
    public String getSignText() {
        return signText;
    }
    public void setSignText(String signText) {
        this.signText = signText;
    }
}
