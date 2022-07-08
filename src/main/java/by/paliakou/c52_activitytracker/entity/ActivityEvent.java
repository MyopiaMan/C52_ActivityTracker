package by.paliakou.c52_activitytracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "activityEvents")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @Enumerated(EnumType.STRING)
    private TypeOfActivity type;
    private int purpose;
    private LocalDateTime activityStartTime;
    private LocalDateTime activityEndTime;
    private int distance;
    private int speed;
    private int elevationGain;
    private BigDecimal activityEnergy;
    private int activityPulse;
    private int repetitions;
    private LocalDateTime repetitionStartTime;
    private BigDecimal repetitionEnergy;
}
