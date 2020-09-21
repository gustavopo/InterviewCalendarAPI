package tamanna.challange.interviews.model.Schedule;

import lombok.Data;
import lombok.Generated;
import tamanna.challange.interviews.model.Person.Candidate;
import tamanna.challange.interviews.model.Person.Interviewer;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
public class RequestedInterviewDates {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    private LocalDateTime requestedDate;
}

