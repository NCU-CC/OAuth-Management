package tw.edu.ncu.cc.manage.dao;

import java.util.List;
import java.util.Optional;

import tw.edu.ncu.cc.manage.domain.BlacklistUser;

public interface IBlacklistUserDao {
	public BlacklistUser create(BlacklistUser user);

	public List<BlacklistUser> search(BlacklistUser dto);

	public Optional<BlacklistUser> find(String username);

	public BlacklistUser update(BlacklistUser user);

	public void remove(BlacklistUser user);
}
