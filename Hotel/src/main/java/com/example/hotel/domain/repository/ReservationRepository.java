package com.example.hotel.domain.repository;

import com.example.hotel.domain.modal.reservation.Reservation;
import com.example.hotel.domain.modal.reservation.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
}
