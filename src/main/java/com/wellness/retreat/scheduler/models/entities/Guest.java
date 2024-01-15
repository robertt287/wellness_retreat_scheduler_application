package com.wellness.retreat.scheduler.models.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;

    @ManyToMany(mappedBy = "guests")
    private Set<Retreat> retreats = new HashSet<>();

    // Standard constructors, getters, and setters

    public Guest() {
    }

    // Additional constructors, getters and setters below
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Retreat> getRetreats() {
        return retreats;
    }

    public void setRetreats(Set<Retreat> retreats) {
        this.retreats = retreats;
    }

    // You can also include methods to add and remove retreats
    public void addRetreat(Retreat retreat) {
        this.retreats.add(retreat);
        retreat.getGuests().add(this);
    }

    public void removeRetreat(Retreat retreat) {
        this.retreats.remove(retreat);
        retreat.getGuests().remove(this);
    }
}

