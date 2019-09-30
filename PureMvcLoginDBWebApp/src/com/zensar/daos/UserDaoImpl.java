package com.zensar.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zensar.entities.User;
/**
 * @author Priya mirchandani
 * @version 1.0
 * @creation_date 21 sep 2019 5.23 pm
 * @modification_date 21 sep 2019 5.23pm
 * @copyright Zensar Technologies ,All rights reserved
 * @description- it is data access object interface implementor class
 *               it is used in persistance layer of application
 *
 */
public class UserDaoImpl implements UserDao {
     
	private Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insert(User user) throws SQLException {
		// TODO Auto-generated method stub
           String sql="Insert into user_login values(?,?)";
           PreparedStatement pst=connection.prepareStatement(sql);
           pst.setString(1, user.getUsername());
           pst.setString(2, user.getPassword());
           int insertCount=pst.executeUpdate();
           if(insertCount>0)
           {
        	   System.out.println("new user inserted");
           }
           else
        	   System.out.println("Sorry! new user cant be inserted");
	}

	@Override
	public void update(User user)throws SQLException {
		// TODO Auto-generated method stub
		String sql="update user_login set password=? where username=? ";
		PreparedStatement ps=connection. prepareStatement(sql);
		ps.setString(1,user.getPassword());
		ps.setString(2, user.getUsername());
		int updateCount=ps.executeUpdate();
		if(updateCount>0)
			System.out.println("user record is updated successfully");
		else
			System.out.println("user record couldnot be updated");

	}

	@Override
	public void delete(User user)throws SQLException{
		// TODO Auto-generated method stub
		String sql="delete from user_login where username=? ";
		PreparedStatement ps=connection. prepareStatement(sql);
		ps.setString(1, user.getUsername());
		int deleteCount=ps.executeUpdate();
		if(deleteCount>0)
			System.out.println("user record is deleted successfully");
		else
			System.out.println("user record couldnot be deleted");
		
	}

	@Override
	public User getByUsername(String username)throws SQLException {
		// TODO Auto-generated method stub
		String sql="Select username,password from user_login where username=?";
		PreparedStatement pst=connection.prepareStatement(sql);
		pst.setString(1, username);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			User user=new User();
             user.setUsername(rs.getString(1));
             user.setPassword(rs.getString(2));
             return user;
		}
		else
		{
		return null;
	}
		}

	@Override
	public List<User> getAll()throws SQLException {
		// TODO Auto-generated method stub
		String sql="select username,password from user_login";
		Statement st=connection.createStatement();
		ResultSet rs=st.executeQuery(sql);
		List<User>users=new ArrayList<User>();
		while(rs.next())
		{
			User user=new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			users.add(user);
		}
		return users;
	}

}
