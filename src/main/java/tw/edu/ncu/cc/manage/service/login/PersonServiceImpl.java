package tw.edu.ncu.cc.manage.service.login;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.ServiceImpl;

@Service
public class PersonServiceImpl <T extends Person> extends ServiceImpl<T> implements IPersonService<T>{

    @SuppressWarnings("unchecked")
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
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
        System.out.println("creat person: "+person.getAccount());
        this.getDao().create(person);
        System.out.println("2creat person: "+person.getAccount());
    }

}
