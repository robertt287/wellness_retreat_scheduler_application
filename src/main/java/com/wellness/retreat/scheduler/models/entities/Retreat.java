package com.wellness.retreat.scheduler.models.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Retreat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "retreat_guest",
            joinColumns = @JoinColumn(name = "retreat_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private Set<Guest> guests = new HashSet<>();


    public Retreat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Guest> getGuests() {
        return guests;
    }

    public void setGuests(Set<Guest> guests) {
        this.guests = guests;
    }


    public void addGuest(Guest guest) {
        this.guests.add(guest);
        guest.getRetreats().add(this);
    }

    public void removeGuest(Guest guest) {
        this.guests.remove(guest);
        guest.getRetreats().remove(this);
    }
}
