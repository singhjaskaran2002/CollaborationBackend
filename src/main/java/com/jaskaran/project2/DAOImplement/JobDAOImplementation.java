package com.jaskaran.project2.DAOImplement;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaskaran.project2.DAO.JobDAO;
import com.jaskaran.project2.Domain.Job;
import com.jaskaran.project2.Domain.JobApplication;

@Transactional
@Repository("jobDAO")
public class JobDAOImplementation implements JobDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean saveJob(Job job) {
		try {
			sessionFactory.getCurrentSession().save(job);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateJob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Job getJob(int jobid) {
		return (Job) sessionFactory.getCurrentSession().createCriteria(Job.class).add(Restrictions.eq("jobid", jobid)).uniqueResult();
	}

	public List<Job> jobList() {
		return sessionFactory.getCurrentSession().createQuery("from Job").list();
	}

	public List<Job> jobList(char jobstatus) {
		return sessionFactory.getCurrentSession().createCriteria(Job.class).add(Restrictions.eq("jobstatus", jobstatus)).list();
	}

	public boolean saveJobApplication(JobApplication jobApplication) {
		try {
			sessionFactory.getCurrentSession().save(jobApplication);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(JobApplication jobApplication) {
		try {
			sessionFactory.getCurrentSession().update(jobApplication);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<JobApplication> list(int jobid) {
		return sessionFactory.getCurrentSession().createCriteria(JobApplication.class).add(Restrictions.eq("jobid", jobid)).list();
	}

	public List<JobApplication> list(int jobid, char jobstatus) {
		return sessionFactory.getCurrentSession().createCriteria(Job.class).add(Restrictions.eq("jobstatus", jobstatus)).add(Restrictions.eq("jobid", jobid)).list();
	}

	public boolean isJobOpened(int jobid) {
		Job job = (Job) sessionFactory.getCurrentSession().createCriteria(Job.class).add(Restrictions.eq("jobid", jobid)).uniqueResult();

		if (job != null && job.getJobstatus() == 'N') {
			return true;
		}

		return false;

	}

	/**
	 * This method will return true if the job already applied with this emaild.
	 * else, return false
	 */

	public boolean isJobAlreadyApplied(String email, int jobid) {

		//select * from JobApplication where emailID = ? and jobID = ?
		JobApplication jobApplication = (JobApplication) sessionFactory.getCurrentSession()
				.createCriteria(JobApplication.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("jobid", jobid)).uniqueResult();

		if (jobApplication == null) {
			return false;
		}
		return true;

	}
}
