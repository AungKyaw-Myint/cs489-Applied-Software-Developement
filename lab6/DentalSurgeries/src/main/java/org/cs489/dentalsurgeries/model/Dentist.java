package org.cs489.dentalsurgeries.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "dentist")
@NoArgsConstructor
@Data
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dentist_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointments;

    public Dentist(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email     = email;
        this.phone     = phone;
    }
}
