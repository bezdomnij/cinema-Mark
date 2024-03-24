package pm.practice.cinema.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pm.practice.cinema.domain.Reservation;
import pm.practice.cinema.domain.Screening;
import pm.practice.cinema.dto.incoming.ReservationCreateCommandDto;
import pm.practice.cinema.repository.ReservationRepository;

@Service
@Transactional
public class ReservationService {

    private final ScreeningService screeningService;
    private final ReservationRepository reservationRepository;

    public ReservationService(ScreeningService screeningService, ReservationRepository reservationRepository) {
        this.screeningService = screeningService;
        this.reservationRepository = reservationRepository;
    }

    public void saveReservation(ReservationCreateCommandDto command) {
        Long screeningId = command.getSelectedScreeningId();
        Screening selectedScreening = screeningService.getScreeningById(screeningId);
        if (selectedScreening == null) {
            throw new EntityNotFoundException("The screening can't be found!");
        }
        Reservation reservationToSave = new Reservation(
                command.getClientName(),
                command.getSeatCountRequired(),
                selectedScreening
        );
        reservationRepository.save(reservationToSave);
    }
}
