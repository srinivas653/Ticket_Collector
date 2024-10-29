package com.example.TicketSeller.Service;

import com.example.TicketSeller.Domain.EventTicket;
import com.example.TicketSeller.Repository.TicketSellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TicketSellerImplement implements ITicketSeller{


    private TicketSellerRepository ticketSellerRepository;

    @Autowired
    public TicketSellerImplement(TicketSellerRepository ticketSellerRepository) {
        this.ticketSellerRepository = ticketSellerRepository;
    }



    @Override
    public List<EventTicket> getQuantity(int seller_id) {
        return ticketSellerRepository.findBySellerId(seller_id);
    }

    @Override
    public EventTicket  saveTickets(EventTicket eventTicket) {
        return ticketSellerRepository.save(eventTicket);
    }

    @Override
    public Integer countTicketsSold(int sellerId) {
        return ticketSellerRepository.countTicketsSoldBySellerId(sellerId);
    }

    @Override
    public Map<Integer, Integer> getTotalEarningsBySeller() {
        List<Object[]> results = ticketSellerRepository.getTotalEarningsBySeller();
        Map<Integer, Integer> earningsMap = new HashMap<>();

        for (Object[] result : results) {
            Integer sellerId = (Integer) result[0];
            Integer totalEarnings = ((Number) result[1]).intValue();
            earningsMap.put(sellerId, totalEarnings);
        }
        return earningsMap;
    }



}
