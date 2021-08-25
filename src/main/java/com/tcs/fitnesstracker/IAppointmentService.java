package com.tcs.fitnesstracker;

import java.util.Optional;


public interface IAppointmentService {
	void save(Appointment appointment);
	Iterable<Appointment> getAllAppointments();
	Optional<Appointment> getAppointment(Integer id);
	void deleteAppointment(Integer id);


}
