package pm.practice.cinema.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pm.practice.cinema.dto.incoming.ScreeningCreateCommand;
import pm.practice.cinema.service.ScreeningService;

@RestController
@RequestMapping("/api/screenings")
@Slf4j
public class ScreeningController {

    private ScreeningService screeningService;

    @Autowired
    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @PostMapping
    public ResponseEntity<Void> saveScreening(@RequestBody ScreeningCreateCommand command) {
        screeningService.saveScreening(command);
        log.info("New screening added, Http Request: POST, /api/screenings, BODY: " + command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
