package com.tcs.fitnesstracker.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.fitnesstracker.Appointment;
import com.tcs.fitnesstracker.repository.IAppointmentRepository;
import com.tcs.fitnesstracker.exception.*;

import org.springframework.util.StringUtils;




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
	@Override
	public void updateAppointment(Appointment appointment, Integer id) {
		Optional<Appointment> appointmentFromDB = appointmentRepo.findById(id);
		if (!appointmentFromDB.isPresent()) {
			throw new AppointmentNotFoundException("appointment  does not exist");
		}
		Appointment appointment1 = appointmentFromDB.get();
		if (StringUtils.hasText(appointment.getTrainerName())) {
			appointment1.setTrainerName(appointment.getTrainerName());
		}
		if(StringUtils.hasText(appointment.getPackageName())) {
			appointment1.setPackageName(appointment.getPackageName());
		}
		if(appointment.getAmount()>0)
			appointment1.setAmount(appointment.getAmount());
		if(appointment.isPhysioRequired())
			appointment1.setPhysioRequired(true);
		else if(appointment1.isPhysioRequired()==true && appointment.isPhysioRequired()==false)
			appointment1.setPhysioRequired(false);

		
		
		appointmentRepo.save(appointment1);

	
	}

}
