package tw.edu.ncu.cc.manage.controller;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.manage.entity.User;
import tw.edu.ncu.cc.manage.service.IUserService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class UserController extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private int id;
    private User user;
    private IUserService userService;

    public String add() {

        userService.save(user);
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IUserService getUserService() {
        return userService;
    }

    @Inject
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

}
