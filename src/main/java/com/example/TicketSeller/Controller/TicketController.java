package com.example.TicketSeller.Controller;

import com.example.TicketSeller.Domain.EventTicket;
import com.example.TicketSeller.Service.ITicketSeller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final ITicketSeller iTicketSeller;

    @Autowired
    public TicketController(ITicketSeller iTicketSeller) {
        this.iTicketSeller = iTicketSeller;
    }


    @PostMapping("/save")
    public ResponseEntity<EventTicket> saveTickets(@RequestBody EventTicket eventTicket) {
        EventTicket savedTicket = iTicketSeller.saveTickets(eventTicket);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }


    @GetMapping("/{sellerId}")
    public ResponseEntity<List<EventTicket>> getQuantity(@PathVariable int sellerId) {
        List<EventTicket> quantity = (List<EventTicket>) iTicketSeller.getQuantity(sellerId);
        return new ResponseEntity<>(quantity, HttpStatus.OK);
    }

    @GetMapping("/count-sold/{sellerId}")
    public ResponseEntity<Integer> countTicketsSold(@PathVariable int sellerId) {
        Integer totalSold = iTicketSeller.countTicketsSold(sellerId);
        return new ResponseEntity<>(totalSold, HttpStatus.OK);
    }


    @GetMapping("/total-earnings")
    public ResponseEntity<Map<Integer, Integer>> getTotalEarningsBySeller() {
        Map<Integer, Integer> totalEarnings = iTicketSeller.getTotalEarningsBySeller();
        return new ResponseEntity<>(totalEarnings, HttpStatus.OK);
    }
}
