package tw.edu.ncu.cc.manage.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tw.edu.ncu.cc.manage.entity.Person;

@Service
public class PersonServiceImpl <T extends Person> extends ServiceImpl<T> implements IPersonService<T>{

    @SuppressWarnings("unchecked")
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
    public T findPersonByAccount(String account) {
        List<T> person = this.getDao().creatQuery(
                "select p from Person p " +
                        "where p.account = :account and deleted=false "
                        ).setParameter("account", account.trim()).getResultList();
        if(person.size()>0){
            return person.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void create(T person) {
        if(findPersonByAccount(person.getAccount())!=null){
            throw new RuntimeException("account " +person.getAccount() + "has already existed");
        }
        this.getDao().create(person);
    }

}
