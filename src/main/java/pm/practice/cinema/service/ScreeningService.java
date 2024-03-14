package pm.practice.cinema.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pm.practice.cinema.domain.Screening;
import pm.practice.cinema.dto.incoming.ScreeningCreateCommand;
import pm.practice.cinema.repository.ScreeningRepository;

@Service
@Transactional
public class ScreeningService {

    private ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public void saveScreening(ScreeningCreateCommand command) {
        Screening toSave = mapDtoToEntity(command);
        screeningRepository.save(toSave);
    }

    private Screening mapDtoToEntity(ScreeningCreateCommand command) {
        Screening screening = new Screening();
        screening.setTitle(command.getTitle());
        screening.setScreeningDate(command.getScreeningDate());
        screening.setSeats(command.getSeats());
        screening.setPictureUrl(command.getPictureUrl());
        return screening;
    }
}
