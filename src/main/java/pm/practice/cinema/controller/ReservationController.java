package pm.practice.cinema.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pm.practice.cinema.domain.Screening;
import pm.practice.cinema.dto.incoming.ReservationCreateCommandDto;
import pm.practice.cinema.dto.outgoing.ScreeningItemForReservationFormDto;
import pm.practice.cinema.dto.outgoing.ScreeningListItemDto;
import pm.practice.cinema.service.ReservationService;
import pm.practice.cinema.service.ScreeningService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final ScreeningService screeningService;

    @Autowired
    public ReservationController(ReservationService reservationService, ScreeningService screeningService) {
        this.reservationService = reservationService;
        this.screeningService = screeningService;
    }

    @PostMapping
    public ResponseEntity<Void> saveReservation(@RequestBody ReservationCreateCommandDto command) {
        reservationService.saveReservation(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/screenings")
    public List<ScreeningItemForReservationFormDto> getScreeningList() {
        List<ScreeningListItemDto> allScreenings = screeningService.getScreeningList();
        return allScreenings.stream().map(ScreeningItemForReservationFormDto::new).toList();
    }

}
