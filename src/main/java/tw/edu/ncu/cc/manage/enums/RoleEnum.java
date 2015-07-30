package tw.edu.ncu.cc.manage.enums;

import java.util.List;

import com.google.inject.internal.Lists;

/**
 * 使用者角色
 * @author yyc1217
 *
 */
public enum RoleEnum {
	ROLE_STUDENT,		//學生
	ROLE_FACULTY,		//教職員工
	ROLE_ALUMNI,		//校友
	ROLE_ADMIN,			//系統管理者
	ROLE_ANONYMOUS		//你誰？
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
