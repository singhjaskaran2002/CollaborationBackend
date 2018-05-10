package com.jaskaran.project2.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jaskaran.project2.DAO.JobDAO;
import com.jaskaran.project2.Domain.Job;
import com.jaskaran.project2.Domain.JobApplication;


public class JobDAOTestCase 
{
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static Job job;
	
	@Autowired
	private static JobApplication jobApplication;
	
	@Autowired
	private static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jaskaran");
		context.refresh();
		jobDAO = (JobDAO)context.getBean("jobDAO");
		job = (Job)context.getBean("job");
		jobApplication = (JobApplication) context.getBean("jobApplication");
	}
	
	@Test
	public void jobAddTestCase()
	{
		job.setJobtitle("BackEnd Developer");
		job.setJobdescription("developing software using spring mvc");
		job.setJobqualification("MCA");
		job.setJobsalary(300000);
		job.setNo_of_openings(2);
		
		assertEquals("job Add Test Case", true, jobDAO.saveJob(job));
	}
	
	@Test
	public void deleteJobTestCase()
	{
		assertEquals("job delete test case", true, jobDAO.deleteJob(102));
	}
	

	@Test
	public void getJobSuccessTestCase()
	{
		Job job = jobDAO.getJob(101);
		assertNotNull(job);
		System.out.println(job.getJobid()+" "+job.getJobdescription()+" "+job.getJobtitle());	
		
	}
	
	@Test
	public void getJobFailureTestCase()
	{
		//assertNotNull(jobDAO.getJob(400));
		assertNull(jobDAO.getJob(400));
	}
	
	@Test
	public void jobListTestCase()
	{
		assertEquals(2, jobDAO.jobList().size());
	}
	
	@Test
	public void jobClosingTestCase()
	{
		job	= jobDAO.getJob(101);
		job.setJobstatus('C');
		assertEquals("updating job test case", true ,jobDAO.updateJob(job));
	}
	
	@Test
	public void isJobOpendSuccessTestCase()
	{
	   assertEquals("JobOpened Success test case", true, jobDAO.isJobOpened(103));
	}
	
	@Test
	public void isJobOpendFailureTestCase()
	{
	   assertEquals("JobOpened failure test case", false, jobDAO.isJobOpened(101));
	}
	
	
	
	//Related to Job Application
	
	
	@Test
	public void applyForJobSuccessTestCase()
	{
		jobApplication.setEmail("jaskaran@gmail.com");
		jobApplication.setJobid(103);
		
		assertEquals("apply for job success test case", true, jobDAO.saveJobApplication(jobApplication));
	}
	
	@Test 
	public void isJobAlreadyAppliedTestCase()
	{
		assertEquals("is job already applied", true, jobDAO.isJobAlreadyApplied("jaskaran@gmail.com", 101));
	}
}
