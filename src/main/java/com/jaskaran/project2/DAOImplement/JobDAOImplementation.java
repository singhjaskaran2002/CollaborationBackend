package com.jaskaran.project2.DAOImplement;

import java.util.Date;
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
	
	private int getMaxJobID() {
		int maxValue = 100;
		try {
				maxValue = (Integer) sessionFactory.getCurrentSession().createQuery("select max(jobid) from Job").uniqueResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 100;
			}
			return maxValue;
	}
	
	public boolean saveJob(Job job) {
		try {
			job.setJobid(getMaxJobID() + 1);
			job.setJob_posted_date(new Date());
			job.setJobstatus('N');
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
	
	private int getMaxJobapplicationID() {
		int maxValue = 100;
		try {
			maxValue = (Integer) sessionFactory.getCurrentSession().createQuery("select max(jobappid) from JobApplication").uniqueResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 100;
		}
		return maxValue;
	}	
	
	public boolean isJobOpened(int jobid) {
		Job job = (Job) sessionFactory.getCurrentSession().createCriteria(Job.class).add(Restrictions.eq("jobid", jobid)).uniqueResult();

		if (job != null && job.getJobstatus() == 'N') {
			return true;
		}
		return false;
	}

	public boolean saveJobApplication(JobApplication jobApplication) {
		try {
				jobApplication.setJobappid(getMaxJobapplicationID() + 1);
				jobApplication.setJobappstatus('N');
				jobApplication.setApplied_date(new Date());
				if(jobApplication.getReason() == null || jobApplication.getReason() == " ")
				{
					jobApplication.setReason("Interested");
				}
				
				sessionFactory.getCurrentSession().save(jobApplication);
				return true;
				
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
	}

	public boolean updateJobApplication(JobApplication jobApplication) {
		try {
			sessionFactory.getCurrentSession().update(jobApplication);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<JobApplication> jobApplicationlist(int jobid) {
		return sessionFactory.getCurrentSession().createCriteria(JobApplication.class).add(Restrictions.eq("jobid", jobid)).list();
	}

	public List<JobApplication> jobApplicationlist(int jobid, char jobstatus) {
		return sessionFactory.getCurrentSession().createCriteria(Job.class).add(Restrictions.eq("jobstatus", jobstatus)).add(Restrictions.eq("jobid", jobid)).list();
	}

	/**
	 * This method will return true if the job already applied with this emaild.
	 * else, return false
	 */

	public boolean isJobAlreadyApplied(String loginname, int jobid) {

		//select * from JobApplication where emailID = ? and jobID = ?
		JobApplication jobApplication = (JobApplication) sessionFactory.getCurrentSession()
				.createCriteria(JobApplication.class)
				.add(Restrictions.eq("loginname", loginname))
				.add(Restrictions.eq("jobid", jobid)).uniqueResult();

		if (jobApplication == null) {
			return false;
		}
		return true;
	}

	public List<JobApplication> jobApplicationList(String loginname) {
		return sessionFactory.getCurrentSession().createCriteria(JobApplication.class).add(Restrictions.eq("loginname", loginname)).list();
	}

	public boolean deleteJob(int jobid) {
		try {
			sessionFactory.getCurrentSession().delete(getJob(jobid));
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
}
