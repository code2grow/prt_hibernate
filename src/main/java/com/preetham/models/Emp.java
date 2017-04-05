package com.preetham.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="emp")
public class Emp implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	  private long id;
	  
	  @NotNull
	  @Size(min = 3, max = 80)
	  private String name;
	  
	  @NotNull
	  private int deptid;
	  
	  public Emp(){}
	  
}
