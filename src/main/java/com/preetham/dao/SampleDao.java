package com.preetham.dao;

import java.util.List; 

import com.preetham.models.User;

public interface SampleDao {
	  public void save(User user);
	  public void delete(User user);
	  public List<User> getAll();
	  public User getByEmail(String email);
	  public User getById(long id) ;
	  public void update(User user) ;
	  
}
