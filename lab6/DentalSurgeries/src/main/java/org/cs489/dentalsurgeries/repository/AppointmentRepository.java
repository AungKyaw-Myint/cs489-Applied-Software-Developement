package org.cs489.dentalsurgeries.repository;

import org.cs489.dentalsurgeries.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    Optional<Appointment> findByAppointmentCode(String appointmentCode);
}
