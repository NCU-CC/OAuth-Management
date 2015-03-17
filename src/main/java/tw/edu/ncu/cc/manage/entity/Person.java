package tw.edu.ncu.cc.manage.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Person extends BaseBean{

    private String account;
    private String password;
    private String type;
    private String name; 
    private String email;
    private String ipCreated;
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date dateLastActived;
    private String ipLastActived;
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getIpCreated() {
        return ipCreated;
    }
    public void setIpCreated(String ipCreated) {
        this.ipCreated = ipCreated;
    }
    public Date getDateLastActived() {
        return dateLastActived;
    }
    public void setDateLastActived(Date dateLastActived) {
        this.dateLastActived = dateLastActived;
    }
    public String getIpLastActived() {
        return ipLastActived;
    }
    public void setIpLastActived(String ipLastActived) {
        this.ipLastActived = ipLastActived;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }   
}