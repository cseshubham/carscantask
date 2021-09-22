package com.svs.usermanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svs.usermanage.entity.User;
import com.svs.usermanage.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		
		User newUser=userRepository.save(user);
		
		return newUser;
	}

	@Override
	public User findUserById(long id) {
		// TODO Auto-generated method stub
		User newUser=userRepository.getById(id);
		
		return newUser;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		User updateUser=userRepository.save(user);
		
		return updateUser;
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public List<User> findAll() {
		List<User> userList=userRepository.findAll();
		return userList;
	}
	
	
}
