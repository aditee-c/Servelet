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
 * @author Aditee Chourasiya
 * @version 1.0
 * @creation_date 21st Sep 2019 5.35PM
 * @modification_date 23st Sep 2019 10.18PM
 * @copyright Zensar Technologies. All rights reserved.
 * @description It is Data Access Object Interface Implementer class.
 * 				It is used in persistance layer of application
 *
 */
public class UserDaoImpl implements UserDao {
	private Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insert(User user)throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into user_login values(?,?)";
		
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			int insertCount = pst.executeUpdate();
			if(insertCount>0) {
				System.out.println("New User is inserted");
				
			}else {
				System.out.println("Sorry! new user could not be inserted");
			}
			
		
	}

	@Override
	public void update(User user) throws SQLException{
		// TODO Auto-generated method stub
		String sql="update user_login set password=? where username=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, user.getPassword());
		pst.setString(2, user.getUsername());
		int rs = pst.executeUpdate();
		if(rs>0) {
			System.out.println("User record is Updated successfully");
			
			
		}else
			System.out.println("Sorry! user is not updated");
	}

	@Override
	public void delete(User user) throws SQLException{
		// TODO Auto-generated method stub
		String sql="delete from user_login  where username=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, user.getUsername());
		int rs = pst.executeUpdate();
		if(rs>0) {
			System.out.println("User record is deleted");
		
		}else
			System.out.println("Sorry! User could  not be deleted");
	}

	@Override
	public User getByUsername(String username) throws SQLException{
		// TODO Auto-generated method stub
		String sql="select username,password from user_login where username=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, username);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			User user = new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			return user;
		}else
			return null;
	}

	@Override
	public List<User> getAll() throws SQLException{
		// TODO Auto-generated method stub
		
		String sql = "select username,password from user_login";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<User> users= new ArrayList<User>();
		while(rs.next()) {
			User user = new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			users.add(user);
		}
		return users;
	}

}
