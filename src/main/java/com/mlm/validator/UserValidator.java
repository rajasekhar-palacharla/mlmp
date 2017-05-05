package com.mlm.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mlm.model.Login;
import com.mlm.model.WebUser;

@Component
public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return WebUser.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		try{
		WebUser webuser = (WebUser) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "USER_EMAIL_ID",
				"webuser.USER_EMAIL_ID.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "USER_PASSWORD",
				"webuser.USER_PASSWORD.empty");
		if (webuser.getUSER_CONTACT_NO() == null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors,
					"USER_CONTACT_NO", "webuser.USER_CONTACT_NO.empty");
		}
		if (webuser.getUSER_ROLE().equals("Select")) {
			webuser.setUSER_ROLE("");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "USER_ROLE",
					"webuser.USER_ROLE.empty");
		}
		}catch (Exception e) {

		}
	}


	public void validateLoginDetails(Object target, Errors errors) {
		try{
		Login login = (Login) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
				"login.username.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"login.password.empty");
		}catch (Exception e) {

		}
	}
}
