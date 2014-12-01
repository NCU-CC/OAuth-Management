package tw.edu.ncu.cc.manage.service.login;

import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.IService;

public interface IPersonService<T extends Person> extends IService<T>{
    T findPersonByAccount(String account);
}
