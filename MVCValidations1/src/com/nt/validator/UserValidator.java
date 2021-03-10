package com.nt.validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nt.command.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return User.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "uname", "uname.required");
		ValidationUtils.rejectIfEmpty(errors, "upwd", "upwd.required");
		ValidationUtils.rejectIfEmpty(errors, "uage", "uage.required");
		ValidationUtils.rejectIfEmpty(errors, "uemail", "uemail.required");
		ValidationUtils.rejectIfEmpty(errors, "umobile", "umobile.required");
		
		User user = (User)command;
		if(!user.getUpwd().equals("") && user.getUpwd().length() < 6) {
		errors.rejectValue("upwd", "upwd.minLength");
		}
		if(!user.getUpwd().equals("") && user.getUpwd().length() > 10) {
		errors.rejectValue("upwd", "upwd.maxLength");
		}
		if(user.getUage() < 18 || user.getUage() > 30) {
		errors.rejectValue("uage", "uage.range");
		}
		if(!user.getUemail().equals("") && !user.getUemail().contains("@")) {
		errors.rejectValue("uemail", "uemail.invalid");
		}
		if(!user.getUmobile().equals("") && !user.getUmobile().startsWith("91-")) {
		errors.rejectValue("umobile", "umobile.invalid");
		 } 
		
	}

}
