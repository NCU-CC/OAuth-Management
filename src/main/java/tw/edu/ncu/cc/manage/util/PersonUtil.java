package tw.edu.ncu.cc.manage.util;

import javax.servlet.http.HttpServletRequest;

import tw.edu.ncu.cc.manage.entity.Person;

public class PersonUtil {
    public static final String PERSON_INFO = "personInfo";
    public static PersonInfo getPersonInfo(HttpServletRequest request){
        return (PersonInfo) request.getSession(true).getAttribute(PERSON_INFO);
    }
    public static void setPersonInf(HttpServletRequest request,PersonInfo personInfo){
        request.getSession(true).setAttribute(PERSON_INFO, personInfo);
    }
    public static void setPersonInf(HttpServletRequest request,Person person){
        PersonInfo personInfo=new PersonInfo();
        personInfo.setId(person.getId());
        personInfo.setAccount(person.getAccount());
        setPersonInf(request, personInfo);
    }
}
