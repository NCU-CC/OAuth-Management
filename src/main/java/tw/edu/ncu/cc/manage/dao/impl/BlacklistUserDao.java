package tw.edu.ncu.cc.manage.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.web.util.UriComponentsBuilder;

import tw.edu.ncu.cc.manage.dao.IBlacklistUserDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractOAuthServiceDao;
import tw.edu.ncu.cc.manage.domain.BlacklistUser;

@Repository
public class BlacklistUserDao extends AbstractOAuthServiceDao<BlacklistUser> implements IBlacklistUserDao {

	private static final ParameterizedTypeReference<List<BlacklistUser>> parameterizedTypeReference = new ParameterizedTypeReference<List<BlacklistUser>>() {};
	
	@Override
	protected ParameterizedTypeReference<List<BlacklistUser>> parameterizedTypeReferenceForList() {
		return parameterizedTypeReference;
	}
	
	@Override
	public BlacklistUser create(BlacklistUser user) {
		Assert.notNull(user);
		return post(blacklistUserUrl(), user);
	}

	@Override
	public List<BlacklistUser> search(BlacklistUser dto) {
		Assert.notNull(dto);
		
		String url = UriComponentsBuilder.fromHttpUrl(blacklistUserUrl())
				.queryParam("user_name", dto.getUsername())
				.build(false).toUriString();
		
		return getList(url);
	}

	@Override
	public Optional<BlacklistUser> find(String username) {
		Assert.hasText(username);
		return get(withUrl(blacklistUserUrl(), username));
	}

	@Override
	public BlacklistUser update(BlacklistUser user) {
		Assert.notNull(user);
		return put(withUrl(blacklistUserUrl(), user.getUsername()), user);
	}

	@Override
	public void remove(BlacklistUser user) {
		Assert.notNull(user);
		delete(withUrl(clientUrl(), user.getUsername()));
	}
}
