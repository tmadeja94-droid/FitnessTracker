package pl.wsb.fitnesstracker.healthmetrics;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "HealthMetrics")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class HealthMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Nullable
    private Long user_id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "weight", nullable = false)
    private int weight;

    @Column(name = "height", nullable = false)
    private int height;

    @Column(name = "hearthRate", nullable = false)
    private int hearthRate;

    public HealthMetrics(@Nullable Long id, @Nullable Long user_id, LocalDate date, int weight, int height, int hearthRate) {
        this.id = id;
        this.user_id = user_id;
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.hearthRate = hearthRate;
    }
}
