package com.preetham.controllers;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preetham.dto.SaveRequest;
import com.preetham.dto.SaveResponse;
import com.preetham.models.User;
import com.preetham.models.UserDao;

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/org")
public class UserController_org {

  @Autowired
  private UserDao _userDao;
  
  @RequestMapping(value="/delete")
  public String delete(long id) {
    try {
      User user = new User(id);
      _userDao.delete(user);
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
      User user = _userDao.getByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch(Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }

  @RequestMapping(value="/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
  public SaveResponse create(@RequestBody SaveRequest request) {
	   SaveResponse response = new SaveResponse(); 
	  try {
      User user = new User(request.getEmail(), request.getName());
      _userDao.save(user);
      response.setContent("User succesfully saved!");
    }
    catch(Exception ex) {
      response.setErrorFlag(true);
      response.setErrorContent("Some Exception occured");
      return response;
    }
    
    return response;
  }

} // class UserController
