package pm.practice.cinema.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private LocalDateTime screeningDate;

    @Column
    private Integer totalSeats;

    @Column(columnDefinition = "TEXT")
    private String pictureUrl;

    @OneToMany(mappedBy = "screening")
    private List<Reservation> reservations;

}
