package tamanna.challange.interviews.model.Person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tamanna.challange.interviews.model.Schedule.AvailableInterviewDates;
import tamanna.challange.interviews.model.Interview;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ApiModel(description = "Entity that represents the Interviewer")
public class Interviewer extends Person{
    @OneToMany(mappedBy = "interviewer")
    @JsonIgnore
    @ApiModelProperty(notes ="Interviewer Interview List")
    private List<Interview> interview;

    @OneToMany(mappedBy = "interviewer")
    @ApiModelProperty(notes ="List of Available Interviewer Dates ")
    private List<AvailableInterviewDates> availableDates;

    public Interviewer() {
    }

    public Interviewer(Long l, String name) {
        this.setId(l);
        this.setName(name);
    }
}
