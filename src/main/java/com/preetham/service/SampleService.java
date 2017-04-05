package com.preetham.service;

import java.util.List;

import com.preetham.models.User;

public interface SampleService {

	 public void save(User user);
	 public void delete(User user);
	 public void getAll();
	 public User getByEmail(String email);
	 public User getById(long id) ;
	 public void update(User user) ;
	 public List<User> getUserByName(String name);
	 public List<User> getUserByNamedQuery();
     public List<User> getUserByEmail(String email);
}
