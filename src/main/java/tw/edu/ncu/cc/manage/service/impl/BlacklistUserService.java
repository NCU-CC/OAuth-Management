package tw.edu.ncu.cc.manage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.dao.IBlacklistUserDao;
import tw.edu.ncu.cc.manage.domain.BlacklistUser;
import tw.edu.ncu.cc.manage.service.IBlacklistUserService;

@Service
public class BlacklistUserService implements IBlacklistUserService {

	@Autowired
	private IBlacklistUserDao blacklistUserDao;
	
	@Override
	public BlacklistUser create(BlacklistUser user) {
		return this.blacklistUserDao.create(user);
	}

	@Override
	public List<BlacklistUser> search(BlacklistUser dto) {
		return this.blacklistUserDao.search(dto);
	}

	@Override
	public Optional<BlacklistUser> find(String username) {
		return this.blacklistUserDao.find(username);
	}

	@Override
	public BlacklistUser update(BlacklistUser user) {
		return this.blacklistUserDao.update(user);
	}

	@Override
	public void remove(BlacklistUser user) {
		this.blacklistUserDao.remove(user);
	}

}
