package tw.edu.ncu.cc.manage.util;

import java.io.Serializable;

public class PersonInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String type;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private String account;
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
}
