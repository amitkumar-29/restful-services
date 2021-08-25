package com.tcs.fitnesstracker.repository;
import org.springframework.data.repository.CrudRepository;

import com.tcs.fitnesstracker.Appointment;


public interface IAppointmentRepository  extends CrudRepository<Appointment, Integer>{

}
