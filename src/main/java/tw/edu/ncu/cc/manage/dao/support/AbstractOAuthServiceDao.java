package tw.edu.ncu.cc.manage.dao.support;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource("classpath:OAuth-service.properties")
public abstract class AbstractOAuthServiceDao<T> extends AbstractRestfulClientDao<T> {

	@Autowired
	private Environment env;

	private String rootUrl;

	@PostConstruct
	private void init() {
		setRootUrl(env.getRequiredProperty("oauth.root"));
	}

	public void setRootUrl(String rootUrl) {
		this.rootUrl = rootUrl;
	}
	
	protected String userUrl() {
		return rootUrl + "users";
	}

	protected String clientUrl() {
		return rootUrl + "clients";
	}

	protected String tokenUrl() {
		return rootUrl + "authorized_tokens";
	}

	protected String managerUrl() {
		return rootUrl + "managers";
	}

	protected String apiTokenUrl() {
		return rootUrl + "api_tokens";
	}

	protected String blacklistClientUrl() {
		return rootUrl + "blacklist/clients";
	}
	
	protected String blacklistUserUrl() {
		return rootUrl + "blacklist/users";
	}
}