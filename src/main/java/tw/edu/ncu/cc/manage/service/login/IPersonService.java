package tw.edu.ncu.cc.manage.service.login;

import javax.servlet.http.HttpServletRequest;

import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.entity.oauth.User;
import tw.edu.ncu.cc.manage.service.IService;

public interface IPersonService<T extends Person> extends IService<T>{
    public static final String SERVICEURL = "https://140.115.3.97/oauth/management/v1/user/";
    T findPersonByAccount(String account);
    Person getNewLoginPerson(HttpServletRequest request,String id);
    User createUserOnRemoteServer(String id);
}
