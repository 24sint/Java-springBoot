package com.tts.rsvrInClass.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.rsvrInClass.model.User;
import com.tts.rsvrInClass.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInt {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	@Override
	public User findUserById(Long id) {
		return userRepository.findUserById();
	}
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	@Override
	public User updateUserById(Long id, User userFromForm) {
		User userFromDb = findUserById(id);
		
	// userFromDb.saveName(userFromForm.getUserName;
	// userFromDb.saveemail(userFromForm.getUseremail;
		
		BeanUtils.copyProperties(userFromForm, userFromDb);
		return userRepository.save(userFromDb);
	}
	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
		
	}

	
}
