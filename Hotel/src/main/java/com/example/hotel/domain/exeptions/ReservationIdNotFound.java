package com.example.hotel.domain.exeptions;

public class ReservationIdNotFound extends RuntimeException{
    public ReservationIdNotFound(String message) {
        System.out.println(String.format("Reservation with id:%s not found",message));
    }
}
