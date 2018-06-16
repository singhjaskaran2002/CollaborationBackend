package com.jaskaran.project2.DAOImplement;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaskaran.project2.DAO.UserDAO;
import com.jaskaran.project2.Domain.User;

@Transactional
@Repository("userDAO")
public class UserDAOImplementation implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public boolean saveUser(User user) {
		
		try {
			if(user.getRole()==null || user.getRole()==" ")
			{
				user.setRole("ROLE_USER");
			}
			user.setStatus('N');
			
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(String email) {
		try {	
						// before delete, first check whether the record
						User user = getUser(email);
						//existing or not
						//if the record does not exist, simply return false;
						if(user==null)
						{
							return false;
						}
						//if the record exist, the delete
			
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public User getUser(String email) {
		return sessionFactory.getCurrentSession().get(User.class, email);
	}

	public List<User> userList() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User validateUser(String email, String password) {
		User user;
		user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password)).uniqueResult();
		return user;
	}

	public User getUserByName(String username) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where username = '"+username+"'").uniqueResult();
	}

}
