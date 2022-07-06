package by.paliakou.c52_activitytracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sleepEvents")
public class SleepEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    private LocalDateTime sleepStartTime;
    private LocalDateTime sleepFinishTime;
    @Enumerated(EnumType.STRING)
    private StageOfSleep stageOfSleep;
    private int rating;

}
