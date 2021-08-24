package com.tcs.fitnesstracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AppointmentController {
	
	@Autowired
	IAppointmentService appointService;
	@GetMapping("/getappointment")
	private String getAppointment() {
		System.out.println("Get request called");
		return "hello";
	}
	
	@PostMapping("/appointment")
	public void saveAppointment(@RequestBody Appointment appointment) {
		appointService.save(appointment);
		System.out.println(appointment.getAppointmentId());
	}


}
