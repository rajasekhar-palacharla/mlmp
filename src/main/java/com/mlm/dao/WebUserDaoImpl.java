package com.mlm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mlm.model.WebUser;

@Repository("webUserDao")
public class WebUserDaoImpl implements WebUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public WebUser verifyWebUser(String uname, String pwd) {
		WebUser webUser = null;
		try{
		String hql = "FROM WebUser U WHERE U.USER_EMAIL_ID = :uname AND U.USER_PASSWORD = :pwd";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("uname", uname);
		query.setParameter("pwd", pwd);
		List<WebUser> results = query.list();
		for (WebUser webuser : results) {
			webUser = webuser;
		}
		}catch (Exception e) {

		}
		return webUser;
	}


}
