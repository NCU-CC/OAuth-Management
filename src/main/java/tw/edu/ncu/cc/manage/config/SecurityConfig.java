package tw.edu.ncu.cc.manage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import tw.edu.ncu.cc.manage.security.MyFailureHandler;
import tw.edu.ncu.cc.manage.security.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	public static final String AX_NAME_ROLE = "axNameRoles"; 
	
	@Autowired
	private MyUserDetailService myUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		
		.logout()
			.logoutUrl("/logout")
			.and()
			
		.openidLogin()
			.failureHandler(failureHandler())
			.successHandler(successHandler())
			.loginPage("/login")
			.defaultSuccessUrl("/", true)
			.authenticationUserDetailsService(myUserDetailsService)
			.attributeExchange("https://portal.ncu.edu.tw/user")
				.attribute("axNameRoles").type("http://axschema.org/user/roles").required(true).and()
				.and()
			.and()
			
		.authorizeRequests()

			.antMatchers("/resources/**").permitAll()
			.antMatchers("/error/**").permitAll()
			.antMatchers("/login**").permitAll()
			.anyRequest().authenticated()
		.and()
		
		.sessionManagement()
			.maximumSessions(1)

		;
	}
	
	@Bean
	protected AuthenticationFailureHandler failureHandler() {
		AuthenticationFailureHandler handler = new MyFailureHandler();
		return handler;
	}
	
	@Bean
	protected SavedRequestAwareAuthenticationSuccessHandler successHandler() {
		SavedRequestAwareAuthenticationSuccessHandler handler = new SavedRequestAwareAuthenticationSuccessHandler();
		handler.setDefaultTargetUrl("/");
		return handler;
	}

}