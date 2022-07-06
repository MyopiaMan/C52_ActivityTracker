package by.paliakou.c52_activitytracker.entity.parameters;

import by.paliakou.c52_activitytracker.entity.User;
import by.paliakou.c52_activitytracker.entity.UserGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.persistence.Table;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "bodyParameters")
public class UserBodyParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @Enumerated(EnumType.STRING)
    private UserGender userGender;
    private int age;
    private BigDecimal weight;
    private BigDecimal height;
}
