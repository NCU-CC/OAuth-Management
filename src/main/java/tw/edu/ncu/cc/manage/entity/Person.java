package tw.edu.ncu.cc.manage.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.inject.internal.Sets;

@Entity
//@Table(name = "person")
public class Person implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private boolean deleted;

	@Version
	private Integer version;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dateCreated;

	private String account;

	private String password;

	@Enumerated(EnumType.STRING)
	private RoleEnum type;

	private String name;

	private String email;

	private String ipCreated;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dateLastActived;

	private String ipLastActived;
	
	Collection<? extends GrantedAuthority> authorities;

	public Person() {
	}
	
	public Person(String userName) {
		this.account = userName;
		this.authorities = Sets.newHashSet();
	}
	
	public Person(String userName, Collection<? extends GrantedAuthority> authorities) {
		this.account = userName;
		this.authorities = authorities;
	}

	public String getAccount() {
		return account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getDateLastActived() {
		return dateLastActived;
	}

	public String getEmail() {
		return email;
	}

	public Integer getId() {
		return id;
	}

	public String getIpCreated() {
		return ipCreated;
	}

	public String getIpLastActived() {
		return ipLastActived;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public RoleEnum getType() {
		return type;
	}

	@Override
	public String getUsername() {
		return account;
	}

	public Integer getVersion() {
		return version;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !isDeleted();
	}

	@Override
	public boolean isAccountNonLocked() {
		return !isDeleted();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !isDeleted();
	}

	public boolean isDeleted() {
		return deleted;
	}

	@Override
	public boolean isEnabled() {
		return !isDeleted();
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDateLastActived(Date dateLastActived) {
		this.dateLastActived = dateLastActived;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIpCreated(String ipCreated) {
		this.ipCreated = ipCreated;
	}

	public void setIpLastActived(String ipLastActived) {
		this.ipLastActived = ipLastActived;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setType(RoleEnum type) {
		this.type = type;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}