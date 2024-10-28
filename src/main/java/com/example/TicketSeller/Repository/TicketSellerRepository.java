package com.example.TicketSeller.Repository;

import com.example.TicketSeller.Domain.EventTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketSellerRepository extends JpaRepository<EventTicket, Integer> {
    List<EventTicket> findBySellerId(int sellerId);
    @Query("SELECT SUM(e.soldBy) FROM ticket e WHERE e.sellerId = ?1")
    Integer countTicketsSoldBySellerId(int sellerId);



}

