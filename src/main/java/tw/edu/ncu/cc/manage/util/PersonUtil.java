package tw.edu.ncu.cc.manage.util;

import javax.servlet.http.HttpServletRequest;


import tw.edu.ncu.cc.manage.entity.Person;


public class PersonUtil {
    public static final String PERSON_INFO = "personInfo";
    public static PersonInfo getPersonInfo(HttpServletRequest request){
        return (PersonInfo) request.getSession(true).getAttribute(PERSON_INFO);
    }
    public static boolean isLogined(HttpServletRequest request){
        PersonInfo personInfo= getPersonInfo(request);
        if(personInfo==null){
            return false;
        }
        String tmpId=personInfo.getAccount();
        if(tmpId!=null && tmpId.length()>0){                 
                return true;
        }                        
        return false;
    }
    public static void setPersonInf(HttpServletRequest request,PersonInfo personInfo){
        request.getSession(true).setAttribute(PERSON_INFO, personInfo);
    }
    public static void setPersonInf(HttpServletRequest request,Person person){
        PersonInfo personInfo=new PersonInfo();
        personInfo.setId(person.getId());
        personInfo.setAccount(person.getAccount());
        personInfo.setType(person.getType());
        setPersonInf(request, personInfo);
    }
    public static String getStudentId(HttpServletRequest request){
        PersonInfo personInfo=getPersonInfo(request);
        String tmpId=personInfo.getAccount();
        return tmpId;
    }
}
