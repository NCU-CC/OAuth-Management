package tw.edu.ncu.cc.manage.entity;

import java.util.List;

import com.google.inject.internal.Lists;

public enum RoleEnum {
	ROLE_STUDENT,
	ROLE_FACULTY,
	ROLE_ALUMNI,
	ROLE_ADMIN,
	ROLE_ANONYMOUS
	;

	/**
	 * 回傳第一個符合的
	 * @param roles
	 * @return
	 */
	public static RoleEnum matchOne(List<String> roles) {
		for (RoleEnum role : values()) {
			if (roles.indexOf(role.name()) > -1) {
				return role;
			}
		}
		return ROLE_ANONYMOUS;
	}

	public static List<String> availableRoles() {
		return Lists.newArrayList(ROLE_STUDENT.name(), ROLE_FACULTY.name(), ROLE_ALUMNI.name(), ROLE_ADMIN.name());
	}
}
