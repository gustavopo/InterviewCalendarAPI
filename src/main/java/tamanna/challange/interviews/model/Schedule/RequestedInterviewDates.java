package tamanna.challange.interviews.model.Schedule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Generated;
import tamanna.challange.interviews.model.Person.Candidate;
import tamanna.challange.interviews.model.Person.Interviewer;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@ApiModel(description = "Entity that represents Candidates Requested Dates")
public class RequestedInterviewDates {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="candidate_id")
    @JsonIgnore
    @ApiModelProperty(notes ="Candidate")
    private Candidate candidate;
    @ApiModelProperty(notes ="Requested date by the associated Candidate")
    private LocalDateTime requestedDate;
}

