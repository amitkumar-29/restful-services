package com.tcs.fitnesstracker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Appointment {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer appointmentId;
	private String trainerName;
	private boolean physioRequired;
	private String packageName;
	private int amount;
	public Integer getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public boolean isPhysioRequired() {
		return physioRequired;
	}
	public void setPhysioRequired(boolean physioRequired) {
		this.physioRequired = physioRequired;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

		
}
