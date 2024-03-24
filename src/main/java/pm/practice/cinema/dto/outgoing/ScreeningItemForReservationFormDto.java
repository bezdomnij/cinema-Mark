package pm.practice.cinema.dto.outgoing;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScreeningItemForReservationFormDto {

    private Long screeningId;
    private String title;
    @JsonFormat(pattern = "yyy-MM-dd HH:mm")
    private LocalDateTime screeningDateTime;

    public ScreeningItemForReservationFormDto(ScreeningListItemDto screeningListItemDto) {
        this.screeningId = screeningListItemDto.getId();
        this.title = screeningListItemDto.getTitle();
        this.screeningDateTime = screeningListItemDto.getScreeningTime();
    }
}
