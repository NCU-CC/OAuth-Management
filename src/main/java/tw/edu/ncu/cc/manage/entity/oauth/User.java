package tw.edu.ncu.cc.manage.entity.oauth;

public class User {
    private String name;
    public User(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
