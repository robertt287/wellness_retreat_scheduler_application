package com.wellness.retreat.scheduler.models.entities;



import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "email_address")
    private String email;

    @Column(name = "phone_number")
    private String phone;

    @ManyToMany(mappedBy = "guests")
    private Set<Retreat> retreats = new HashSet<>();
}

