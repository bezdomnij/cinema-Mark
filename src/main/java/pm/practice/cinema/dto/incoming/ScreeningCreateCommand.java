package pm.practice.cinema.dto.incoming;

import jakarta.validation.constraints.Future;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ScreeningCreateCommand {

    private String title;
    @Future
    private LocalDateTime screeningDate;
    private Integer totalSeats;
    private String pictureUrl;

}
