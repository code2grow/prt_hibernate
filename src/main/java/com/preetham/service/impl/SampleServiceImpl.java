package com.preetham.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preetham.dao.impl.SampleDaoImpl;
import com.preetham.models.User;
import com.preetham.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private SampleDaoImpl sampleDaoImpl;

    @Override
    public void save(User user) {
    	sampleDaoImpl.save(user);
    }

	@Override
	public void delete(User user) {
		sampleDaoImpl.delete(user);
	}

	@Override
	public void getAll() {
		List<User> list = new ArrayList<User>();
		list.add(new User("preetham","preetham@gmail.com"));
		list.add(new User("kp","kp@gmail.com"));
	}

	@Override
	public User getByEmail(String email) {
		User user =sampleDaoImpl.getByEmail(email);
		return user;
	}

	@Override
	public User getById(long id) {
		User user =sampleDaoImpl.getById(id);
		return user;
	}

	@Override
	public void update(User user) {
		sampleDaoImpl.update(user);
		
	}

	@Override
	public List<User> getUserByNamedQuery() {
		List<User> users= sampleDaoImpl.getUserByNamedQuery();
		return users!=null?users:null;
	}

	@Override
	public List<User> getUserByName(String name) {
		List<User> users= sampleDaoImpl.getUserByName(name);
		return users!=null?users:null;
	}

	@Override
	public List<User> getUserByEmail(String email) {
		List<User> users= sampleDaoImpl.getUserByEmail(email);
		return users!=null?users:null;
	}
	
	
}
