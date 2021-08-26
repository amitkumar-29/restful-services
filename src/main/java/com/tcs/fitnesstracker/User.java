package com.tcs.fitnesstracker;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class User {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer ID;
	@NotBlank(message = "first Name is mandatory")
    private String firstName;
	private String lastName;
	
	@Size(min=10, max=80,message="Age is either less than 10 or more than 80")
    private int age;
	private String Address;
	
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<Appointment> appoinments;

	


	
}
