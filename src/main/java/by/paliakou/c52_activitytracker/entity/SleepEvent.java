package by.paliakou.c52_activitytracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sleepEvents")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SleepEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    private LocalDateTime sleepStartTime;
    private LocalDateTime sleepFinishTime;
    @Enumerated(EnumType.STRING)
    private StageOfSleep stage;
    private LocalDateTime stageStartTime;
    private int rating;
}
