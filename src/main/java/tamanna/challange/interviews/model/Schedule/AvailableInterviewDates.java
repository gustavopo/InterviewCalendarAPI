package tamanna.challange.interviews.model.Schedule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Generated;
import tamanna.challange.interviews.model.Person.Interviewer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@ApiModel(description = "Entity that represents Interviewers Available Dates")
public class AvailableInterviewDates {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="interviewer_id")
    @JsonIgnore
    @ApiModelProperty(notes ="Interviewer")
    private Interviewer interviewer;
    @ApiModelProperty(notes ="Available date by the associated Interviewer")
    private LocalDateTime availableDate;

}
