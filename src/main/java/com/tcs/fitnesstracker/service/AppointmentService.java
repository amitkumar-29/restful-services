package com.tcs.fitnesstracker.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.fitnesstracker.Appointment;
import com.tcs.fitnesstracker.AppointmentNotFoundException;
import com.tcs.fitnesstracker.repository.IAppointmentRepository;




@Service
public class AppointmentService implements IAppointmentService {
	@Autowired
IAppointmentRepository appointmentRepo;

	@Override
	
	public void save(Appointment appointment) {
		// TODO Auto-generated method stub
		appointmentRepo.save(appointment);
		System.out.println("Appointment saved");
		
		}
	  @Override
	   public Iterable<Appointment> getAllAppointments() {
		return appointmentRepo.findAll();
		
		

		
	}
	@Override
	public Optional<Appointment> getAppointment(Integer id) {
		// TODO Auto-generated method stub
		Optional<Appointment> appointment = appointmentRepo.findById(id);
		if (!appointment.isPresent()) {
			throw new AppointmentNotFoundException("appointment  does not exist");
		}
		return appointment;
	}
	@Override
	public void deleteAppointment(Integer id) {
		// TODO Auto-generated method stub
		Optional<Appointment> appointment = appointmentRepo.findById(id);
		if (!appointment.isPresent()) {
			throw new AppointmentNotFoundException("appointment  does not exist");
		}
		appointmentRepo.deleteById(id);

	}

}
