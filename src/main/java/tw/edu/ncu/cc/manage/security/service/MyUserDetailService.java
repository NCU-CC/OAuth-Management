package tw.edu.ncu.cc.manage.security.service;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.entity.Person;

@Service
public class MyUserDetailService implements AuthenticationUserDetailsService<OpenIDAuthenticationToken> {

	private static Logger logger = Logger.getLogger(MyUserDetailService.class);
	
	@Override
	public UserDetails loadUserDetails(OpenIDAuthenticationToken token) throws UsernameNotFoundException {
		logger.debug(token);
		return new Person(token.getName());
	}

}
