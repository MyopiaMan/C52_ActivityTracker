package by.paliakou.c52_activitytracker.entity;

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
public class ActivityEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @Enumerated(EnumType.STRING)
    private TypeOfActivity typeOfActivity;
    private int purpose;
    private LocalDateTime activityStartTime;
    private LocalDateTime activityEndTime;
    private int repetitions;
    private int distance;
    private int speed;
    private int elevationGain;
    private BigDecimal activeEnergy;
    private int activityPulse;
}
