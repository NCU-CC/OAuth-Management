package tw.edu.ncu.cc.manage.service;

import tw.edu.ncu.cc.manage.entity.Person;

public interface IUserContextService {
	
	public Person getCurrentUser();
	
	public String getCurrentUsername();
}
