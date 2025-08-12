package com.nucompany.parkingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nucompany.parkingsystem.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
