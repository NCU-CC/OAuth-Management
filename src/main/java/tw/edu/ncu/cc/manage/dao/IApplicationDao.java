package tw.edu.ncu.cc.manage.dao;

import java.util.List;

import tw.edu.ncu.cc.manage.entity.oauth.application.IdApplication;

public interface IApplicationDao {

	List<IdApplication> findAll(String userId);

}
