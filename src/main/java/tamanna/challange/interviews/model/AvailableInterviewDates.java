package tamanna.challange.interviews.model;

import lombok.Data;
import lombok.Generated;
import tamanna.challange.interviews.model.Person.Interviewer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
public class AvailableInterviewDates {

    @Id
    @Generated
    private int id;

    @ManyToOne
    @JoinColumn(name="interviewer_id")
    private Interviewer interviewer;

    private LocalDateTime availableDate;
}
