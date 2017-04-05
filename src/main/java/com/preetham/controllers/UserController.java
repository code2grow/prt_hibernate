package com.preetham.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preetham.dto.SaveRequest;
import com.preetham.dto.SaveResponse;
import com.preetham.models.User;
import com.preetham.service.SampleService;


@RestController
@EnableAutoConfiguration
@RequestMapping(value="/user")
public class UserController {

  @Autowired
  private SampleService sampleService;
  
  @RequestMapping(value="/delete")
  public String delete(long id) {
    try {
      User user = new User(id);
      sampleService.delete(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }
  
  @RequestMapping(value="/get-by-email")
  public String getByEmail(String email) {
    String userId;
    try {
      User user = sampleService.getByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch(Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }

  @RequestMapping(value="/fetch", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public SaveResponse create(@RequestBody SaveRequest request) {
	   SaveResponse response = new SaveResponse();
	   List<User> users =  new ArrayList<User>();
	  try {
      User user = new User(request.getEmail(), request.getName());
      if(request.getEmail()==null && request.getName()==null){
    	users = sampleService.getUserByNamedQuery();
      }
     else if(request.getEmail()!=null){
    	users = sampleService.getUserByName("preetham");
     }
     else if(request.getName()!=null){
        users= sampleService.getUserByEmail("kp@gmail.com");
     }
     if(users==null || users.size()==0){
    	  response.setErrorFlag(true);
    	  response.setContent("User from R Query is null");
    	  return response;
      }
      
      response.setContent("User succesfully fetched!. Check the User");
      response.setUser(user);
    }
    catch(Exception ex) {
      response.setErrorFlag(true);
      response.setErrorContent("Some Exception occured");
      return response;
    }
    
    return response;
  }

} // class UserController
