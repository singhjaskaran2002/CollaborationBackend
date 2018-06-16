package com.jaskaran.project2.DAOImplement;

import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jaskaran.project2.DAO.ProfileDAO;
import com.jaskaran.project2.Domain.Profile;

@Repository("profileDAO")
@Transactional
public class ProfileDAOImplementation implements ProfileDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean uploadProfile(Profile Profile) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(Profile);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Profile getProfile(String email) {
		return (Profile) sessionFactory.getCurrentSession().get(Profile.class, email);
	}
	
	
}
