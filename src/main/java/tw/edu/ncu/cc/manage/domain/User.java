package tw.edu.ncu.cc.manage.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import com.google.inject.internal.Sets;

public class User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;

	private transient Collection<? extends GrantedAuthority> authorities;
	
	public User() {
		this.authorities = Sets.newHashSet();
	}
	
	public User(String name, List<String> roles) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return "";
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public void setRoles(List<String> roles) {
		
		if (CollectionUtils.isEmpty(roles)) {
			return;
		}
		
		this.authorities = roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
	}	
}