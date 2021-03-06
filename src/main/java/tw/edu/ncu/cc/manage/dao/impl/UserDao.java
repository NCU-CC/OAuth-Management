package tw.edu.ncu.cc.manage.dao.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.web.util.UriComponentsBuilder;

import tw.edu.ncu.cc.manage.dao.IUserDao;
import tw.edu.ncu.cc.manage.dao.support.AbstractOAuthServiceDao;
import tw.edu.ncu.cc.manage.domain.User;

@Repository
public class UserDao extends AbstractOAuthServiceDao<User> implements IUserDao {
	
	private static final ParameterizedTypeReference<List<User>> parameterizedTypeReference = new ParameterizedTypeReference<List<User>>() {};
	
	@Override
	protected ParameterizedTypeReference<List<User>> parameterizedTypeReferenceForList() {
		return parameterizedTypeReference;
	}	
	
	@Override
	public Optional<User> find(String username) {
		
		if (StringUtils.isEmpty(username)) {
			return Optional.empty();
		}
		
		return get(withUrl(userUrl(), username));
	}

	@Override
	public User create(User user) {
		Assert.notNull(user);
		post(userUrl(), user);
		return user;
	}

	@Override
	public List<User> search(User dto) {
		
		Assert.notNull(dto);
		
		if (StringUtils.isEmpty(dto.getName())) {
			return Collections.emptyList();
		}
		
		String url = UriComponentsBuilder.fromHttpUrl(userUrl())
				.queryParam("name", dto.getName())
				.build(false).toUriString();
		
		return getList(url);
	}
}