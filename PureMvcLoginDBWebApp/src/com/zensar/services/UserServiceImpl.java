package com.zensar.services;

import java.sql.SQLException;
import java.util.List;

import com.zensar.daos.UserDao;
import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;

public class UserServiceImpl implements UserService {
  private UserDao userDao;
  
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		try
		{
			userDao.insert(user);
		}
		catch(Exception e)
		{
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void updateUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			
		
		userDao.update(user);
		}
		catch(SQLException e)
		{
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void removeUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		try {
	    userDao.delete(user);
	     
		}
		catch(SQLException e)
		{
			throw new ServiceException(e.getMessage());
		}
		}

	@Override
	public User findUserByUsername(String username) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			
			
			User user=userDao.getByUsername(username);
		      return user;
			}
			catch(SQLException e)
			{
				throw new ServiceException(e.getMessage());
			}
		
	}

	@Override
	public List<User> findAllUsers() throws ServiceException {
		// TODO Auto-generated method stub
		try {
			
			
			
		      return userDao.getAll();
			}
			catch(SQLException e)
			{
				throw new ServiceException(e.getMessage());
			}
	}

	@Override
	public boolean validateUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		User dbuser=findUserByUsername(user.getUsername());
		if(dbuser!=null&&dbuser.getPassword().equals(user.getPassword()))
            return true;
         else
	
		return false;
	}

}
