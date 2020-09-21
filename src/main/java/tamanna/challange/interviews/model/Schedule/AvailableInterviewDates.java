package tamanna.challange.interviews.model.Schedule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Generated;
import tamanna.challange.interviews.model.Person.Interviewer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class AvailableInterviewDates {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="interviewer_id")
    @JsonIgnore
    private Interviewer interviewer;

    private LocalDateTime availableDate;

}
