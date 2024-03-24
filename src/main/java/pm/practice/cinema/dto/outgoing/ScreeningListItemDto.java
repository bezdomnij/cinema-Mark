package pm.practice.cinema.dto.outgoing;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ScreeningListItemDto {

    private Long id;
    private String title;
    private LocalDateTime screeningTime;
    private String imageUrl;

}
