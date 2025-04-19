package org.cs489.dentalsurgeries.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cs489.dentalsurgeries.auth.User;

import java.time.LocalDate;
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
    private String    gender;
    private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @JsonManagedReference
    private Address address;

    @OneToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    public Patient(String firstName, String lastName, String gender, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.gender    = gender;
        this.birthDate = birthDate;
    }
}
