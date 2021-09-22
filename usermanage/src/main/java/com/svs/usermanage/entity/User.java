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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

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
	@Size(min = 2,message="First Name should have atleast 2 characters")
	@NotBlank(message="First Name should Not Blank")
	@Pattern(regexp="^[a-zA-Z]*$",message="First Name should have Only Alpha Char")
	private String fName;
	
	@Column(name="l_name")
	@Size(min = 2,message = "Last Name should have atleast 2 characters")
	@NotBlank(message = "Last Name should not blank")
	@Pattern(regexp="^[a-zA-Z]*$",message="Last Name should have Only Alpha Char")
    private String lName;
	
	@Column(name="dob")
	@NotNull(message = "DOB should not be blank")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name="city")
	@Size(min = 2,message = "City Name should have atleast 2 characters")
	@NotBlank(message = "City Name should Not Blank")
	@Pattern(regexp="^[a-zA-Z]*$",message="City Name should have Only Alpha Char")
    private String city;
	
	@Column(name="mobile_number")
	@Size(max=10,min=10,message = "mobileNumber should have 10 characters")
	@NotBlank(message = "mobileNumber should Not blank")
	@Pattern(regexp="^[0-9]*$",message="mobileNumber should have Only Numeric")
	private String mobileNumber;
	
}
