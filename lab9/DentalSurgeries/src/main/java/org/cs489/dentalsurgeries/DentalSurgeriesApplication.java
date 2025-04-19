package org.cs489.dentalsurgeries;

import lombok.RequiredArgsConstructor;
import org.cs489.dentalsurgeries.dto.request.*;
import org.cs489.dentalsurgeries.model.Appointment;
import org.cs489.dentalsurgeries.service.AppointmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class DentalSurgeriesApplication {

    private final AppointmentService appointmentService;

    public static void main(String[] args) {
        SpringApplication.run(DentalSurgeriesApplication.class, args);
    }
//
//    @Bean
//    CommandLineRunner commandLineRunner(DentalSurgeriesApplication app) {
//        return args -> {
//            appointmentService.saveAppointment(
//                    new AppointmentRequest(
//                            "app-1",
//                            "DentalAppointment1",
//                            "For Cleaning",
//                            LocalDate.now(),
//                            null,
//                            null,
//                            new PatientRequest(
//                                    "Den",
//                                    "Lwis",
//                                    "M",
//                                    LocalDate.of(1999,5,9),
//                                    new AddressReqeust(
//                                            14,
//                                            "Street1",
//                                            "Fairfield",
//                                            "Iowa",
//                                            "52557"
//                                    )
//                            ),
//                            new SurgeryRequest(
//                                    "Surgery Center 1",
//                                    "Surgery First Center",
//                                    new AddressReqeust(
//                                            1174,
//                                            "Street30",
//                                            "Fairfield",
//                                            "Iowa",
//                                            "52557"
//                                    )
//                            ),
//                            new DentistRequest(
//                                    "Mical",
//                                    "Smith",
//                                    "micalsmith@gmail.com",
//                                    "555-888-8785"
//                            )
//
//                    )
//                                              );
//
//            System.out.println("Dental Surgeries Appointments :::"+appointmentService.getAllAppointments());
//        };
//    }

}
