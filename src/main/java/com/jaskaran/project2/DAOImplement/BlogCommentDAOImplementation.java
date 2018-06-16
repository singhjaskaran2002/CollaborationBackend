package com.jaskaran.project2.DAOImplement;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaskaran.project2.DAO.BlogCommentDAO;
import com.jaskaran.project2.Domain.BlogComment;

@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDAOImplementation implements BlogCommentDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	private int getMaxBlogCommentID() {
		int maxValue = 100;
		try {
				maxValue = (Integer) sessionFactory.getCurrentSession().createQuery("select max(blogcommentid) from BlogComment").uniqueResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 100;
			}
			return maxValue;
	}
	
	public boolean saveBlogComment(BlogComment blogComment) {
		try {
			blogComment.setBlogcommentid(getMaxBlogCommentID() + 1);
			blogComment.setCommentedDate(new Date());
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	

	public boolean deleteBlogComment(int blogcommentid) {
		// TODO Auto-generated method stub
				return false;
	}

	public boolean updateBlogComment(BlogComment blogComment) {
		try {
			sessionFactory.getCurrentSession().update(blogComment);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public BlogComment getBlogComment(int blogcommentid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BlogComment> blogCommentList(int blogid) {
		return sessionFactory.getCurrentSession().createCriteria(BlogComment.class).add(Restrictions.eq("blogid", blogid)).list();
	}

}
