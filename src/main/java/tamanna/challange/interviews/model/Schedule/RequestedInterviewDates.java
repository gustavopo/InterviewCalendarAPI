package tamanna.challange.interviews.model.Schedule;

import lombok.Data;
import lombok.Generated;
import tamanna.challange.interviews.model.Person.Candidate;
import tamanna.challange.interviews.model.Person.Interviewer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
@Entity
@Data
public class RequestedInterviewDates {
    @Id
    @Generated
    private int id;

    @ManyToOne
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    private LocalDateTime requestedDate;
}

