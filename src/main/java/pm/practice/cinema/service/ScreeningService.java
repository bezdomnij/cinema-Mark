package pm.practice.cinema.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pm.practice.cinema.domain.Screening;
import pm.practice.cinema.dto.incoming.ScreeningCreateCommandDto;
import pm.practice.cinema.dto.outgoing.ScreeningListItemDto;
import pm.practice.cinema.repository.ScreeningRepository;

import java.util.List;

@Service
@Transactional
public class ScreeningService {

    private final ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public void saveScreening(ScreeningCreateCommandDto command) {
        Screening toSave = mapDtoToEntity(command);
        screeningRepository.save(toSave);
    }

    private Screening mapDtoToEntity(ScreeningCreateCommandDto command) {
        Screening screening = new Screening();
        screening.setTitle(command.getTitle());
        screening.setScreeningDate(command.getScreeningDate());
        screening.setTotalSeats(command.getTotalSeats());
        screening.setPictureUrl(command.getPictureUrl());
        return screening;
    }

    public List<ScreeningListItemDto> getScreeningList() {
        List<Screening> screeningList = screeningRepository.findAllByOrderByScreeningDateAsc();
        return screeningList.stream().map(ScreeningListItemDto::new).toList();
    }
}
