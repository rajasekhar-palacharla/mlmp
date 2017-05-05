package com.mlm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mlm.model.Login;





@Controller
public class CommonController {



	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model) {
		try {
			Login login = new Login();
			model.addAttribute("login", login);
		} catch (Exception e) {

		}
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public ModelAndView ShowTree(Model model) {
		try {
			Login login = new Login();
			model.addAttribute("login", login);
		} catch (Exception e) {

		}
		return new ModelAndView("ViewGroups");
	}
  


}
