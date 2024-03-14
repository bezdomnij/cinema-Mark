package pm.practice.cinema.dto.incoming;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ScreeningCreateCommand {

    private String title;
    private LocalDateTime screeningDate;
    private Integer seats;
    private String pictureUrl;

}
