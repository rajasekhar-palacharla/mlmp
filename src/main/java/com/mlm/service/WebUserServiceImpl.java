package com.mlm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mlm.dao.WebUserDao;
import com.mlm.model.WebUser;

/**
 * @author Nasaramma Velivemula
 * 
 */
@Service("webUserService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class WebUserServiceImpl implements WebUserService {

	@Autowired
	private WebUserDao webUserDao;

	@Override
	public WebUser verifyWebUser(String uname, String pwd) {
		return webUserDao.verifyWebUser(uname, pwd);
	}

}
