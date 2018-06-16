package com.jaskaran.project2.DAO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jaskaran.project2.Domain.Forum;

@Component
public interface ForumDAO 
{
	public boolean saveForum(Forum forum);
	public boolean deleteforum(int forumid);
	public Forum getForum(int forumid);
	public boolean approveForum(int forumid);
	public boolean rejectForum(int forumid);
	public List<Forum> approvedForumsList();
	public List<Forum> forumList();
	public boolean incLikes(int blogid);
	
}
