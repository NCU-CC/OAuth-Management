package tw.edu.ncu.cc.manage.service.login;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.entity.PersonType;
import tw.edu.ncu.cc.manage.entity.oauth.User;
import tw.edu.ncu.cc.manage.service.ServiceImpl;
import tw.edu.ncu.cc.manage.service.oauth.connector.Connection;
import tw.edu.ncu.cc.manage.service.oauth.converter.TokenConverter;
import tw.edu.ncu.cc.manage.service.oauth.converter.UserConverter;

@Service
public class PersonServiceImpl <T extends Person> extends ServiceImpl<T> implements IPersonService<T>{
    public Connection connection;
    public PersonServiceImpl() {
        connection= new Connection();
    }
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

    public Person getNewLoginPerson(HttpServletRequest request,String id) {
        Person person= new Person();
        person.setAccount(id);
        person.setDateCreated(new Date());
        person.setDateLastActived(new Date());
        person.setDeleted(false);
        person.setIpCreated(request.getRemoteAddr());
        person.setIpLastActived(request.getRemoteAddr());
        person.setType(PersonType.STUDENT.toString());
        return person;
    }

    public User createUserOnRemoteServer(String id) {
        try {
            HttpURLConnection connectionURL=connection.doConnection(new URL(SERVICEURL), UserConverter.convert(new User(id)), Connection.POST);
            int status=connectionURL.getResponseCode();
            connectionURL.connect();
            if(status==200){
                return UserConverter.convert(connection.getStringFromConnection(connectionURL));
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
