package pm.practice.cinema.dto.incoming;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservationCreateCommandDto {

    private String clientName;
    private Integer seatCountRequired;
    private Long selectedScreeningId;


}
