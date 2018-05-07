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
		job.setJobtitle("Software Developer");
		//job.setJobdescription("developing software using spring mvc");
		job.setJobqualification("MCA");
		job.setJobsalary(200000);
		job.setNo_of_openings(3);
		//job.setJobid(101);
		
		assertEquals("job Add Test Case", true, jobDAO.saveJob(job));
	}
	
}
