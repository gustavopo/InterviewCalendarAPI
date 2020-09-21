package tamanna.challange.interviews.model;
import lombok.Data;
import tamanna.challange.interviews.model.Person.Candidate;
import tamanna.challange.interviews.model.Person.Interviewer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Slot {
    @Id
    @GeneratedValue
    private Integer slotId;

    private LocalDateTime interviewDate;

    @ManyToOne
    private Interviewer interviewer;

    @ManyToOne
    private Candidate candidate;
}
