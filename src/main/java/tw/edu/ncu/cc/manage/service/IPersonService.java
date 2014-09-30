package tw.edu.ncu.cc.manage.service;

import tw.edu.ncu.cc.manage.entity.Person;

public interface IPersonService<T extends Person> extends IService<T>{
    T findPersonByAccount(String account);
}
