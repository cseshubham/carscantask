package com.svs.usermanage.service;



import java.util.List;

import com.svs.usermanage.entity.User;


public interface UserService {

	User createUser(User user);

	User findUserById(long id);

	User updateUser(User user);

	void deleteUserById(long id);

	List<User> findAll();


}
