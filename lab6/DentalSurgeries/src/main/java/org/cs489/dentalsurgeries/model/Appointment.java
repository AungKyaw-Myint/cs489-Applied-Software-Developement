package org.cs489.dentalsurgeries.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "appointment")
@NoArgsConstructor
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointment_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String appointmentCode;
    @Column(nullable = false)
    private String title;
    private String description;

    @Column(nullable = false)
    private LocalDate appointmentDate;
    private String    appointmentType;
    private String appointmentStatus;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST} )
    @JoinColumn(name = "address_id")
    private Patient patient;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST} )
    @JoinColumn(name = "surgery_id")
    private Surgery surgery;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST} )
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    public Appointment(
            String appointmentCode,
            String title,
            String description,
            LocalDate appointmentDate,
            String appointmentType,
            String appointmentStatus
                      ) {
        this.appointmentCode = appointmentCode;
        this.title             = title;
        this.description       = description;
        this.appointmentDate   = appointmentDate;
        this.appointmentType   = appointmentType;
        this.appointmentStatus = appointmentStatus;
    }
}
