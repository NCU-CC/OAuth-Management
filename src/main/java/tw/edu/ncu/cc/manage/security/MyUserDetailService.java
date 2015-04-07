package tw.edu.ncu.cc.manage.security;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.config.SecurityConfig;
import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.enums.RoleEnum;
import tw.edu.ncu.cc.manage.service.IPersonService;

@Service
public class MyUserDetailService implements AuthenticationUserDetailsService<OpenIDAuthenticationToken> {

	private static final Logger logger = Logger.getLogger(MyUserDetailService.class);
	

	
	@Autowired
	private IPersonService personService;
	
	/**
	 * 允許存取本系統的role
	 */
	private static final List<String> PERMIT_ROLES = RoleEnum.availableRoles();

	@Override
	public UserDetails loadUserDetails(OpenIDAuthenticationToken token) throws UsernameNotFoundException, NoSuchUserRoleException {
		
		checkRoleAvailibility(token);
		
		String account = ((String) token.getPrincipal()).substring(SecurityConfig.PORTAL_ENDPOINT.length());
		
		Optional<Person> person = this.personService.findByAccount(account);
		if (person.isPresent()) {
			logger.debug("An old friend, ignore registration step.");
			return person.get();
		}
		
		throw new UsernameNotFoundException("Username not found for " + account);
	}

	/**
	 * 確認該使用者的role是有權限來access本系統
	 * @param token
	 */
	private void checkRoleAvailibility(OpenIDAuthenticationToken token) {
		
		List<OpenIDAttribute> attributes = token.getAttributes();
		for (OpenIDAttribute attribute : attributes) {
			if (isRoleAttribute(attribute)) {
				if (noSuchRoles(attribute)) {
					throw new NoSuchUserRoleException(token, PERMIT_ROLES);
				}
				token.setDetails(attribute.getValues());
			}
		}
	}
	
	/**
	 * 這個attribute是屬性role
	 * @param attribute
	 * @return
	 */
	private boolean isRoleAttribute(OpenIDAttribute attribute) {
		return SecurityConfig.AX_NAME_ROLE.equals(attribute.getName());
	}
	
	/**
	 * 沒有本系統可允許存取的role
	 * @param attribute
	 * @return
	 */
	private boolean noSuchRoles(OpenIDAttribute attribute) {
		String roles = attribute.getValues().get(0);
		boolean hasAnyRole = PERMIT_ROLES.stream().anyMatch(role -> roles.indexOf(role) > -1);
		return !hasAnyRole;
	}
	
}
