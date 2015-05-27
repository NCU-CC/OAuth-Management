package tw.edu.ncu.cc.manage.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import tw.edu.ncu.cc.manage.entity.User;
import tw.edu.ncu.cc.manage.exception.OAuthServiceUnavailableException;
import tw.edu.ncu.cc.manage.service.IUserService;
import tw.edu.ncu.cc.manage.utils.SystemConstant;

@Service
public class UserService implements IUserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	private RestTemplate template = new RestTemplate();

	@Override
	public Optional<User> find(String account) throws OAuthServiceUnavailableException {

		Assert.hasText(account);

		User user;
		try {
			user = template.getForObject(SystemConstant.OAUTH_USER_SERVICE_URL + account, User.class);
		} catch (HttpClientErrorException e) {
			if (is404(e)) {
				logger.error("沒有使用者註冊資料");
				return Optional.empty();
			}
			
			if (isServerSideError(e)) {
				logger.error("OAuth Service連線有問題");
				throw new OAuthServiceUnavailableException(e);
			}
			throw e;
		}
		return Optional.ofNullable(user);
	}

	@Override
	public Optional<User> create(User newUser) throws OAuthServiceUnavailableException {
		
		User user;
	
		try {
			user = template.postForObject(SystemConstant.OAUTH_USER_SERVICE_URL, newUser, User.class);
		} catch (HttpClientErrorException e) {
			if (isServerSideError(e)) {
				logger.error("OAuth Service連線有問題");
				throw new OAuthServiceUnavailableException(e);
			}
			throw e;
		}
		return Optional.ofNullable(user);
	}
	
	private boolean is404(Exception e) {
		return HttpStatus.NOT_FOUND.equals(((HttpClientErrorException) e).getStatusCode());
	}

	private boolean isServerSideError(Exception e) {
		return ((HttpClientErrorException) e).getStatusCode().is5xxServerError();
	}
}
