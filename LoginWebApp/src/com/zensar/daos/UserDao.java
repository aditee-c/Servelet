package com.zensar.daos;

import java.sql.SQLException;
import java.util.List;

import com.zensar.entities.User;

/**
 * @author Aditee Chourasiya
 * @version 1.0
 * @creation_date 21st Sep 2019 5.30PM
 * @modification_date 21st Sep 2019 5.30PM
 * @copyright Zensar Technologies. All rights reserved.
 * @description It is Data Access Object Interface.
 * 				It is used in persistance layer of application
 *
 */
public interface UserDao {
	void insert(User user)throws SQLException;
	void update (User user)throws SQLException;
	void delete(User user)throws SQLException;
	User getByUsername(String username)throws SQLException;
	List<User> getAll()throws SQLException;
}
