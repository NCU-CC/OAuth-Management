package tw.edu.ncu.cc.manage.service;

import tw.edu.ncu.cc.manage.entity.User;

public interface IUserContextService {
	
	public User getCurrentUser();
	
	public String getCurrentUsername();
}
