package com.jaskaran.project2.DAO;

import java.util.List;
import org.springframework.stereotype.Component;
import com.jaskaran.project2.Domain.Job;
import com.jaskaran.project2.Domain.JobApplication;

@Component
public interface JobDAO 
{
	public boolean saveJob(Job job);			
	public boolean updateJob(Job job);			
	public boolean deleteJob(int jobid);		
	public Job getJob(int jobid); 				
	public List<Job> jobList(); 	
	
	public boolean saveJobApplication(JobApplication jobApplication);
	public List<JobApplication> jobApplicationlist(int jobid);
	public List<JobApplication> jobApplications();
	public  boolean isJobAlreadyApplied(String loginname, int jobid);
	public List<JobApplication> jobApplicationList(String loginname);
	public boolean approveApplication(int jobappid);
	public boolean rejectApplication(int jobappid);
	public JobApplication getApplication(int jobappid);
}
