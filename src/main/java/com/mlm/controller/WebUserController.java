package com.mlm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mlm.commonutil.CommonUtils;
import com.mlm.model.Login;
import com.mlm.model.WebUser;
import com.mlm.service.WebUserService;
import com.mlm.validator.UserValidator;


@Controller
public class WebUserController {

	@Autowired
	private WebUserService webUserService;

	@Autowired
	UserValidator userValidator;

	CommonUtils util = new CommonUtils();
	Login login = new Login();


	@RequestMapping(value = "/verifyuser", method = RequestMethod.POST)
	public String verifyUser(@ModelAttribute("login") @Valid Login login,
			BindingResult result, Model model, HttpSession session) {
		try {
			WebUser user = null;
			String role = null;
			userValidator.validateLoginDetails(login, result);
			if (result.hasErrors()) {
				model.addAttribute("error", "true");
				return "login";
			} else {
				user = webUserService.verifyWebUser(login.getUsername(),
						util.base64Encode(login.getPassword().getBytes()));
				if (user != null) {
					role = user.getUSER_ROLE();
					if (role != null) {
						session.setAttribute("userrole", role);
						return "AdminHome";
					} else {
						return "login";
					}
				} else {
					model.addAttribute("fail", "Invalid Login Credentials");
					return "login";
				}
			}
		} catch (Exception e) {

		}
		return "login";
	}




	public UserValidator getUserValidator() {
		return userValidator;
	}

	public void setUserValidator(UserValidator userValidator) {
		this.userValidator = userValidator;
	}

}
