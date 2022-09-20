package com.example.hotel.domain.exeptions;

public class ReservationIdNotFound extends RuntimeException{
    public ReservationIdNotFound() {
        System.out.println(String.format("Reservation with not found"));
    }
}
