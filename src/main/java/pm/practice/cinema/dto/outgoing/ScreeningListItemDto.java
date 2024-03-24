package pm.practice.cinema.dto.outgoing;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import pm.practice.cinema.domain.Reservation;
import pm.practice.cinema.domain.Screening;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ScreeningListItemDto {

    private Long id;
    private String imageUrl;
    private String title;
    @JsonFormat(pattern = "yyy-MM-dd HH:mm")
    private LocalDateTime screeningTime;
    private Integer totalSeats;
    private Integer freeSeats;

    public ScreeningListItemDto(Screening screening) {
        this.id = screening.getId();
        this.imageUrl = screening.getPictureUrl();
        this.title = screening.getTitle();
        this.screeningTime = screening.getScreeningDate();
        this.totalSeats = screening.getTotalSeats();
        this.freeSeats = this.totalSeats - screening.getReservations().stream()
                .map(Reservation::getSeatCountNeeded)
                .mapToInt(value -> value)
                .sum();
    }
}
