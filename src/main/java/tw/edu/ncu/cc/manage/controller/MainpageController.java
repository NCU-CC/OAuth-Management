package tw.edu.ncu.cc.manage.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.manage.util.PersonInfo;
import tw.edu.ncu.cc.manage.util.PersonUtil;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class MainpageController extends ActionSupport {

    private static final long serialVersionUID = 1L;
    @Autowired
    private HttpServletRequest request;    

    @Override
    public String execute() throws Exception {
        request = ServletActionContext.getRequest();
        PersonInfo personInfo=PersonUtil.getPersonInfo(request);
        if(personInfo!=null){
            String tmpId=personInfo.getAccount();
            if(tmpId!=null && tmpId.length()>0){           
                    return SUCCESS;
            }
        }
        return LOGIN;
    }
}
