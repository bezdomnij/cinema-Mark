package pm.practice.cinema.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pm.practice.cinema.dto.incoming.ScreeningCreateCommandDto;
import pm.practice.cinema.dto.outgoing.ScreeningListItemDto;
import pm.practice.cinema.service.ScreeningService;
import pm.practice.cinema.validator.ScreeningCreateCommandValidator;

import java.util.List;

@RestController
@RequestMapping("/api/screenings")
@Slf4j
public class ScreeningController {

    private final ScreeningService screeningService;
    private final ScreeningCreateCommandValidator screeningCreateCommandValidator;

    @Autowired
    public ScreeningController(ScreeningService screeningService, ScreeningCreateCommandValidator screeningCreateCommandValidator) {
        this.screeningService = screeningService;
        this.screeningCreateCommandValidator = screeningCreateCommandValidator;
    }

    @InitBinder("screeningCreateCommandValidator")
    protected void screeningBinder(WebDataBinder binder) {
        binder.addValidators(screeningCreateCommandValidator);
    }

    @PostMapping
    public ResponseEntity<Void> saveScreening(@RequestBody @Valid ScreeningCreateCommandDto command) {
        screeningService.saveScreening(command);
        log.info("New screening added, Http Request: POST, /api/screenings, BODY:\n" + command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScreeningListItemDto>> getScreeningList() {
        ResponseEntity<List<ScreeningListItemDto>> response =
                new ResponseEntity<>(screeningService.getScreeningList(), HttpStatus.OK);
        log.info("Screenings page requested, Http Request: GET. /api/screenings\n");
        return response;
    }
}
