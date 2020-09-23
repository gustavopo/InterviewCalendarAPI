package tamanna.challange.interviews.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tamanna.challange.interviews.model.Person.Candidate;
import tamanna.challange.interviews.model.Person.Interviewer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@ApiModel(description = "Entity that represents an Interview Slot")
public class Interview {
    @Id
    @GeneratedValue
    private Long interview;
    @ApiModelProperty(notes ="Interview Date")
    private LocalDateTime interviewDate;

    @ManyToOne
    @ApiModelProperty(notes ="Interviewer associated with the interview")
    private Interviewer interviewer;

    @ManyToOne
    @ApiModelProperty(notes ="Candidate associated with the interview")
    private Candidate candidate;
}
