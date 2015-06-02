package tw.edu.ncu.cc.manage.service;

import tw.edu.ncu.cc.manage.domain.User;

public interface IUserContextService {
	
	public User getCurrentUser();
	
	public String getCurrentUsername();
}
