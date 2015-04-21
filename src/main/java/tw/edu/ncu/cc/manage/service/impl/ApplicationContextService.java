package tw.edu.ncu.cc.manage.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.IApplicationContextService;

@Service
public class ApplicationContextService implements IApplicationContextService {

	@Override
	public Person getCurrentUser() {
		return (Person) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	@Override
	public String getCurrentUsername() {
		return this.getCurrentUser().getAccount();
	}
}
