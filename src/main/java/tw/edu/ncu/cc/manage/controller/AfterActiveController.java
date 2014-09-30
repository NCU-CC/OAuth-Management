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
public class AfterActiveController extends ActionSupport {
    private static final long serialVersionUID = 1L;    
    private HttpServletRequest request;
    private IPersonService<Person> service;
   
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
                    Date date=new Date();
                    person.setSign_date(date);
                    person.setSign_version(SignVersion.version);
                    service.save(person); 
                    return SUCCESS;
                }
            }
        }                        
        return ERROR;
    }
}
