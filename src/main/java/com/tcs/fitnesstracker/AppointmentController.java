package com.tcs.fitnesstracker;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/appointment")

public class AppointmentController {
	
	@Autowired
	IAppointmentService appointService;
	@GetMapping
	private Iterable<Appointment> getAppointment() {
		return appointService.getAllAppointments();
	}
	@GetMapping("/{id}")
	private Optional<Appointment> getUser(@PathVariable("id") Integer id) {
		return appointService.getAppointment(id);
	}
	@ExceptionHandler(value = AppointmentNotFoundException.class)
	   public ResponseEntity<Appointment> exception(AppointmentNotFoundException appointmentNotFoundException) {
	      return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
	   }
	
	@PostMapping
	public ResponseEntity<String> saveAppointment( @Valid @RequestBody Appointment appointment) {
		appointService.save(appointment);
		//System.out.println(appointment.getAppointmentId());
        return ResponseEntity.ok("appointment  is valid");

	}
	
	@DeleteMapping("/{id}")
	public void deleteAppointment(@PathVariable("id") Integer id) {
		appointService.deleteAppointment(id);
	}


}
