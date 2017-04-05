package com.preetham.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.preetham.constants.QueryConstants;
import com.preetham.models.User;

@Repository
@Transactional
public class SampleDaoImpl{
	 
	  @Autowired
	  private SessionFactory _sessionFactory;

      
	 private Session getSession() {
		    return _sessionFactory.getCurrentSession();
		  }

		  public void save(User user) {
		    getSession().save(user);
		    return;
		  }
		  
		  public void delete(User user) {
		    getSession().delete(user);
		    return;
		  }
		  
		  @SuppressWarnings("unchecked")
		  public List<User> getAll() {
		    return getSession().createQuery("from User").list();
		  }
		  
		  public User getByEmail(String email) {
		    return (User) getSession().createQuery(
		        "from User where email = :email")
		        .setParameter("email", email)
		        .uniqueResult();
		  }

		  public User getById(long id) {
		    return (User) getSession().load(User.class, id);
		  }

		  public void update(User user) {
		    getSession().update(user);
		    return;
		  }
		  
          public List<User> getUserByNamedQuery(){
			Query query=(Query) getSession().getNamedQuery(QueryConstants.GET_ALL_USERS);
			List<User> result = query.list();
			return result!=null?result:null;
          }
		  
          public List<User> getUserByName(String name){
  			Query query=(Query) getSession().getNamedQuery(QueryConstants.GET_USER_BYNAME);
  			query.setParameter("uname", name);
  			List<User> result = query.list();
  			return result!=null?result:null;
            }
          
          public List<User> getUserByEmail(String email){
    			Query query=(Query) getSession().getNamedQuery(QueryConstants.GET_USER_BYEMAIL);
    			query.setParameter("umail", email);
    			List<User> result = query.list();
    			return result!=null?result:null;
              }
		  
}
