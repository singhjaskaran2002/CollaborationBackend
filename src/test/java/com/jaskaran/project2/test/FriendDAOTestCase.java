package com.jaskaran.project2.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.jaskaran.project2.DAO.FriendDAO;
import com.jaskaran.project2.Domain.Friend;
import com.jaskaran.project2.Domain.User;


public class FriendDAOTestCase {
	
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static FriendDAO friendDAO;
	
	@Autowired
	private static Friend friend;

	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.jaskaran");
		context.refresh();
		friendDAO = (FriendDAO)context.getBean("friendDAO");
		friend = (Friend)context.getBean("friend");
	}
	
	@Test
	public void FriendList()
	{
		List<Friend> friends = friendDAO.friendList("sachin@gmail.com");
		boolean flag = friends.isEmpty();
		assertEquals("friend list test case", false, flag);
		for(Friend f:friends)
		{
			System.out.println("Friend Name: "+f.getFriendname());
		}
	}
	
	@Test
	public void pendingFriendList()
	{
		List<Friend> friends = friendDAO.pendingFriendRequestList("singhjaskaran@gmail.com");
		boolean flag = friends.isEmpty();
		assertEquals("friend list test case", false, flag);
		for(Friend f:friends)
		{
			System.out.println("Friend Email: "+f.getFriendname());
		}
	}
	
	/*@Test
	public void suggestedFriendList()
	{
		List<User> users = friendDAO.suggestedPeopleList("Jaskaran Singh");
		boolean flag = users.isEmpty();
		System.out.println(users.size());
		assertEquals("friend list test case", false, flag);
		for(User u:users)
		{
			System.out.println("People Name: "+u.getUsername());
		}
	}*/
	
	@Test
	public void deleteFriendRequest()
	{
		assertEquals("delete friend request test case", true, friendDAO.deleteFriendRequest(102));
	}
	
	@Test
	public void acceptFriendRequest()
	{
		assertEquals("accept friend request test case", true, friendDAO.acceptFriendRequest(103));
	}
}
