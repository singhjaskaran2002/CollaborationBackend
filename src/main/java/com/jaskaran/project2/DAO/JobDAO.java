package com.jaskaran.project2.DAO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jaskaran.project2.Domain.Job;
import com.jaskaran.project2.Domain.JobApplication;

@Component
public interface JobDAO 
{
	public boolean saveJob(Job job);			//done
	public boolean updateJob(Job job);			
	public boolean deleteJob(int jobid);		//done
	public Job getJob(int jobid); 				//done
	public List<Job> jobList(); 				//done
	public List<Job> jobList(char jobstatus); 	//done
	public boolean isJobOpened(int jobid);		//done
	
	//for applying to the particular job
	
	public boolean saveJobApplication(JobApplication jobApplication);						//done
	public boolean updateJobApplication(JobApplication jobApplication); 		// if admin needs to change the status of jobapplication (accept/reject/call for interview)
	public List<JobApplication> jobApplicationlist(int jobid);					// for fetching list of total jobapplications for a particular job based on job id 
	public List<JobApplication> jobApplicationlist(int jobid, char jobstatus);
	public  boolean isJobAlreadyApplied(String email, int jobid);
	public List<JobApplication> jobApplicationList(String email);			//done
}
