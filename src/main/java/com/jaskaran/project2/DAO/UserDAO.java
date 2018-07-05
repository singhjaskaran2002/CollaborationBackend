package com.jaskaran.project2.DAO;

import java.util.List;
import org.springframework.stereotype.Component;
import com.jaskaran.project2.Domain.User;

@Component
public interface UserDAO 
{
	public boolean saveUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(String loginname);
	public User getUser(String loginname);
	public User getUserByName(String username);
	public List<User> userList();
	public User validateUser(String email, String password);
}