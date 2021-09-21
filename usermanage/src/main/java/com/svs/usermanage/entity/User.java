package com.svs.usermanage.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="User")
@Data
public class User {
	/*fname, lname, dob, city, and mobilenumber*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	long id;
	
	@Column(name="f_name")
	private String fName;
	
	@Column(name="l_name")
	private String lName;
	
	@Column(name="dob")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name="city")
	private String city;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
}
