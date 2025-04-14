package org.cs489.dentalsurgeries.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "patient")
@NoArgsConstructor
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    public Patient(String firstName, String lastName, String gender, String birthDate) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.gender    = gender;
        this.birthDate = birthDate;
    }
}
