package com.svs.usermanage.service;

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

}
