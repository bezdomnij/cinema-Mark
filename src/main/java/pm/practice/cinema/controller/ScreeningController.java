package pm.practice.cinema.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pm.practice.cinema.dto.incoming.ScreeningCreateCommand;
import pm.practice.cinema.service.ScreeningService;
import pm.practice.cinema.validator.ScreeningCreateCommandValidator;

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

    @InitBinder
    protected void screeningBinder(WebDataBinder binder) {
        binder.addValidators(screeningCreateCommandValidator);
    }

    @PostMapping
    public ResponseEntity<Void> saveScreening(@RequestBody @Valid ScreeningCreateCommand command) {
        screeningService.saveScreening(command);
        log.info("New screening added, Http Request: POST, /api/screenings, BODY:\n" + command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
