package tw.edu.ncu.cc.manage.controller.login;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;




import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.entity.PersonType;
import tw.edu.ncu.cc.manage.service.login.IPersonService;
import tw.edu.ncu.cc.manage.util.PersonUtil;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class AfterLoginController extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private HttpServletRequest request;

    private IPersonService<Person> service;
    @Inject
    public void setService(IPersonService<Person> service) {
        this.service = service;
    }

    @Override
    public String execute() throws Exception {
        request = ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        String tmpId=((String) session.getAttribute("tmpId")).trim();
        if(tmpId!=null && tmpId.length()>0){
            session.invalidate();
            session=request.getSession(true);
            
            Person person= service.findPersonByAccount(tmpId);
            if(person!=null){
                notNewLogin(person);
                service.save(person);
            }else{
                person= new Person();
                newLogin(person,tmpId);
                service.create(person);
            }
            addInSession(person);            
            return SUCCESS;
        }
        return ERROR;
    }
    private void addInSession(Person person){
        PersonUtil.setPersonInf(request, person);
    }
    private void newLogin(Person person,String id){
        person.setAccount(id);
        person.setDateCreated(new Date());
        person.setDateLastActived(new Date());
        person.setDeleted(false);
        person.setIpCreated(request.getRemoteAddr());
        person.setIpLastActived(request.getRemoteAddr());
        person.setType(PersonType.STUDENT.toString());
    }
    
    private void notNewLogin(Person person){
        person.setDateLastActived(new Date());
        person.setIpLastActived(request.getRemoteAddr());
    }

}