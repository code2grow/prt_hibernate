package com.preetham.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;

import javax.persistence.*;

import com.preetham.constants.QueryConstants;



@NamedQueries({
@NamedQuery(name=QueryConstants.GET_USER_BYEMAIL, query="SELECT u FROM User u WHERE u.email=:umail"),
@NamedQuery(name=QueryConstants.GET_USER_BYNAME,query="SELECT u FROM User u WHERE u.name=:uname"),
@NamedQuery(name=QueryConstants.GET_ALL_USERS, query="FROM User")
})
@Entity
@Table(name="user")
public class User implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;
  
  @NotNull
  @Size(min = 3, max = 80)
  private String email;
  
  @NotNull
  @Size(min = 2, max = 80)
  private String name;

  public User() { }

  public User(long id) { 
    this.id = id;
  }

  public User(String email, String name) {
    this.email = email;
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String value) {
    this.email = value;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String value) {
    this.name = value;
  }
  
} // class User
