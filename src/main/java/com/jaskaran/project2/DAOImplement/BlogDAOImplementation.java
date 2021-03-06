package com.jaskaran.project2.DAOImplement;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jaskaran.project2.DAO.BlogDAO;
import com.jaskaran.project2.Domain.Blog;
import com.jaskaran.project2.Domain.BlogComment;

@Transactional
@Repository("blogDAO")
public class BlogDAOImplementation implements BlogDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	private int getMaxBlogID() {
		int maxValue = 100;
		try {
				maxValue = (Integer) sessionFactory.getCurrentSession().createQuery("select max(blogid) from Blog").uniqueResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 100;
			}
			return maxValue;
	}
	
	public boolean saveBlog(Blog blog) {
		try {
			blog.setBlogid(getMaxBlogID() + 1);
			blog.setBlogcreatedDate(new Date());
			blog.setBlogstatus('N');
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteBlog(int blogid) {
		try {
			sessionFactory.getCurrentSession().delete(getBlog(blogid));
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Blog getBlog(int blogid) {
		return sessionFactory.getCurrentSession().get(Blog.class, blogid);
	}

	public List<Blog> approvedBlogsList() {
		return sessionFactory.getCurrentSession().createQuery("from Blog where blogstatus='A'").list();
	}

	public boolean approveBlog(int blogid) {
		try {
			Blog blog = this.getBlog(blogid);
			blog.setBlogstatus('A');
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean rejectBlog(int blogid) {
		try {
			Blog blog = getBlog(blogid);
			blog.setBlogstatus('R');
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean incLikes(int blogid) {
		try {
			Blog blog = getBlog(blogid);
			blog.setBloglikes(blog.getBloglikes() + 1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<Blog> blogList() {
		return sessionFactory.getCurrentSession().createQuery("from Blog").list();
	}
	
	
	/******************************************************** related to blog comment ****************************************************************/
	
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
	
	public List<BlogComment> blogCommentList(int blogid) {
		return sessionFactory.getCurrentSession().createCriteria(BlogComment.class).add(Restrictions.eq("blogid", blogid)).list();
	}
	
	public BlogComment getComment(int blogcommentid)
	{
		return (BlogComment)sessionFactory.getCurrentSession().get(BlogComment.class, blogcommentid);
	}

	public boolean deletecomment(int blogcommentid) {
		try {
			sessionFactory.getCurrentSession().delete(getComment(blogcommentid));
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public BlogComment getBlogComment(int blogcommentid) {
		return (BlogComment)sessionFactory.getCurrentSession().get(BlogComment.class, blogcommentid);
	}
	
	

}