package com.tts.rsvrInClass.repository;

import java.util.List;

import com.tts.rsvrInClass.model.User;

public interface UserRepository {

	List<User> findAll();
	User findUserById();
	User save(User user);
	void deleteById(Long id);

}
