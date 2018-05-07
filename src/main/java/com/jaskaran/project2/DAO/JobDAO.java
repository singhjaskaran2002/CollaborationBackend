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
	public Job getJob(int jobid);
	public List<Job> jobList();
	public List<Job> jobList(char jobstatus);
	
	//for applying to the particular job
	
	public boolean saveJobApplication(JobApplication jobApplication);
	public boolean update(JobApplication jobApplication); // if admin needs to change the status of jobapplication (accept/reject/call for interview)
	public List<JobApplication> list(int jobid);	// for fetching list of total jobapplications for a particular job based on job id 
	public List<JobApplication> list(int jobid, char jobstatus);
	public  boolean isJobAlreadyApplied(String email, int jobid);
}
