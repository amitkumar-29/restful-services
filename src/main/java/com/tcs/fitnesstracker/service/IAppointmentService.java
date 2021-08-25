package com.tcs.fitnesstracker.service;

import java.util.Optional;

import com.tcs.fitnesstracker.Appointment;


public interface IAppointmentService {
	void save(Appointment appointment);
	Iterable<Appointment> getAllAppointments();
	Optional<Appointment> getAppointment(Integer id);
	void deleteAppointment(Integer id);
    void updateAppointment(Appointment appintment,Integer id);

}
