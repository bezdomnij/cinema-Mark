package pm.practice.cinema.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;

    @Column(name = "moviegoer_name")
    private String moviegoerName;

    @Column(name = "seat_count_needed")
    private Integer seatCountNeeded;

    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screening;

    public Reservation(String moviegoerName, Integer seatCountNeeded, Screening screening) {
        this.moviegoerName = moviegoerName;
        this.seatCountNeeded = seatCountNeeded;
        this.screening = screening;
    }
}
