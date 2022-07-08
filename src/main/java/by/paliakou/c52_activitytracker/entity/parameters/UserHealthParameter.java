package by.paliakou.c52_activitytracker.entity.parameters;

import by.paliakou.c52_activitytracker.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "healthParameters")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserHealthParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    private int oxygenSaturation;
    private BigDecimal bodyTemperature;
    private int heartRate;
    private int pulse;
    private int restingHeartRate;
}
