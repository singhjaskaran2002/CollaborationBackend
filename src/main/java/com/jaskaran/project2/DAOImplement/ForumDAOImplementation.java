package com.jaskaran.project2.DAOImplement;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaskaran.project2.DAO.ForumDAO;
import com.jaskaran.project2.Domain.Blog;
import com.jaskaran.project2.Domain.Forum;

@Transactional
@Repository("forumDAO")
public class ForumDAOImplementation implements ForumDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	private int getMaxForumID() {
		int maxValue = 100;
		try {
				maxValue = (Integer) sessionFactory.getCurrentSession().createQuery("select max(forumid) from Forum").uniqueResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 100;
			}
			return maxValue;
	}
	
	public boolean saveForum(Forum forum) {
		try {
			forum.setForumid(getMaxForumID() + 1);
			forum.setForumstatus('N');
			forum.setForum_created_date(new Date());
			sessionFactory.getCurrentSession().save(forum);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteforum(int forumid) {
		try {
			sessionFactory.getCurrentSession().delete(getForum(forumid));
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Forum getForum(int forumid) {
		return (Forum) sessionFactory.getCurrentSession().get(Forum.class, forumid);
	}

	public boolean approveForum(int forumid) {
		try {
			Forum forum = getForum(forumid);
			forum.setForumstatus('A');
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean rejectForum(int forumid) {
		try {
			Forum forum = getForum(forumid);
			forum.setForumstatus('R');
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<Forum> approvedForumsList() {
		return sessionFactory.getCurrentSession().createQuery("from Forum where forumstatus = 'A'").list();
		
	}

	public List<Forum> forumList() {
		return sessionFactory.getCurrentSession().createQuery("from Forum").list();
	}

	public boolean incLikes(int forumid) {
		try {
			Forum forum = getForum(forumid);
			forum.setForumlikes(forum.getForumlikes() + 1);
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
