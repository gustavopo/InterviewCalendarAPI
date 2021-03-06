package tamanna.challange.interviews.model.Person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tamanna.challange.interviews.model.Schedule.RequestedInterviewDates;
import tamanna.challange.interviews.model.Interview;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ApiModel(description = "Entity that represents the Candidate")
public class Candidate extends Person{

    @OneToMany(mappedBy = "candidate")
    @JsonIgnore
    @ApiModelProperty(notes ="List of available slots for the Candidate's interview")
    private List<Interview> requestedInterviews;

    @OneToMany(mappedBy = "candidate")
    @ApiModelProperty(notes ="List of dates requested by the Candidate")
    private List<RequestedInterviewDates> requestedDates;

    public Candidate() {
    }

    public Candidate(long id, String name) {
        this.setId(id);
        this.setName(name);
    }
}
