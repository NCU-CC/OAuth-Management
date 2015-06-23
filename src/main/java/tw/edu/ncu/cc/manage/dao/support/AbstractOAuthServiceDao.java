package tw.edu.ncu.cc.manage.dao.support;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource("classpath:OAuth-service.properties")
public class AbstractOAuthServiceDao<T> extends AbstractRestfulClientDao<T> {

	@Autowired
	private Environment env;
	
	protected String rootUrl;
	
	protected String userUrl;
	
	protected String clientUrl;
	
	protected String tokenUrl;
	
	protected String managerUrl;
	
	protected String apiTokenUrl;
	
	@PostConstruct
	private void init() {
		rootUrl = env.getRequiredProperty("oauth.root");
		userUrl = rootUrl + "users";
		clientUrl = rootUrl + "clients";
		tokenUrl = rootUrl + "authorized_tokens";
		managerUrl = rootUrl + "managers";
		apiTokenUrl = rootUrl + "api_tokens";
	}
}