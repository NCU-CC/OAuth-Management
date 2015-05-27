package tw.edu.ncu.cc.manage.dao.impl;

import org.springframework.stereotype.Repository;

import tw.edu.ncu.cc.manage.dao.IUserDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractRestfulClientDao;
import tw.edu.ncu.cc.manage.entity.User;

@Repository
public class UserDao extends AbstractRestfulClientDao<User> implements IUserDao {

}
