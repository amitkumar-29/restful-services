package com.tcs.fitnesstracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
