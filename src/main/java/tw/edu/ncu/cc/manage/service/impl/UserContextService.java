package tw.edu.ncu.cc.manage.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.domain.User;
import tw.edu.ncu.cc.manage.service.IUserContextService;

@Service
public class UserContextService implements IUserContextService {

	@Override
	public User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	@Override
	public String getCurrentUsername() {
		return this.getCurrentUser().getName();
	}
}
