package com.jaskaran.project2.DAO;

import java.util.List;


import org.springframework.stereotype.Component;

import com.jaskaran.project2.Domain.Friend;
import com.jaskaran.project2.Domain.User;

@Component
public interface FriendDAO 
{
	public List<Friend> friendList(String loginname);
	public List<Friend> pendingFriendRequestList(String loginname);
	public List<User> suggestedPeopleList(String loginname);

	public boolean sendFriendRequest(Friend friend);
	public boolean acceptFriendRequest(int friendid);
	public boolean deleteFriendRequest(int friendid);
	public Friend getFriend(int friendid);
}
