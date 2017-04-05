package com.preetham.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name="Emp.findAll", query = "SELECT e FROM Emp e"), 
                @NamedQuery(name="User.findAll", query = "SELECT u FROM User u") })

public class Base {
    @Id
    private long id;

}