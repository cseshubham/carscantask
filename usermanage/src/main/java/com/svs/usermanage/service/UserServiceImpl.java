package com.svs.usermanage.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.svs.usermanage.entity.User;
import com.svs.usermanage.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional
	public User createUser(User user) {
		
		User newUser=userRepository.save(user);
		
		return newUser;
	}

	@Override
	public User findUserById(long id) {
		// TODO Auto-generated method stub
		User newUser=userRepository.findById(id).get();
		
		return newUser;
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		User existUser=null;
		try {
			existUser=userRepository.findById(user.getId()).get();
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			throw new NoSuchElementException("Invalid User Id");
		}
		
		User updateUser=userRepository.save(user);
		
		
		return updateUser;
	}

	@Override
	@Transactional
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		try {
			userRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			 throw new NoSuchElementException("Invalid User Id");
		}
		//return false;
	}

	@Override
	public List<User> findAll() {
		List<User> userList=userRepository.findAll();
		if(userList.isEmpty()) {
			throw new NoSuchElementException("No User Found");
		}
		return userList;
	}
	
	
}
