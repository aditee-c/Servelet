package com.zensar.services;

import java.util.List;

import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;

/**
 * @author Aditee Chourasiya
 * @version 1.0
 * @creation_date 21st Sep 2019 5.57PM
 * @modification_date 21st Sep 2019 5.57PM
 * @copyright Zensar Technologies. All rights reserved.
 * @description It is Business Service Interface.
 * 				It is used in Business layer of application
 *
 */
public interface UserService {
	void addUser(User user) throws ServiceException;
	void UpdateUser(User user)throws ServiceException;
	void removeUser(User user)throws ServiceException;
	User findUserByUsername(String username)throws ServiceException;
	List<User> findAllUsers()throws ServiceException;
	boolean validateUser(User user)throws ServiceException;
}
