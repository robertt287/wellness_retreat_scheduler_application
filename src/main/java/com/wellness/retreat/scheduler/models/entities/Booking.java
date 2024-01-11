package com.wellness.retreat.scheduler.models.entities;

import java.time.LocalDate;

public class Booking {


    private Long id;


    private User user;


    private Retreat retreat;


    private LocalDate bookingDate;


    private String status;


    private String paymentStatus;


    private String specialRequests;

}
