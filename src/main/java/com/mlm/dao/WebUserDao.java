package com.mlm.dao;

import java.util.List;

import com.mlm.model.WebUser;

public interface WebUserDao {


	public WebUser verifyWebUser(String uname, String pwd);
}
