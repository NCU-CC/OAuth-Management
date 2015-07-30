package tw.edu.ncu.cc.manage.domain.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mysql.fabric.xmlrpc.Client;

public class ClientValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Client.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "should.not.empty");
	}

}
