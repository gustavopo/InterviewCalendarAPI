package tamanna.challange.interviews.model.Person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import tamanna.challange.interviews.model.AvailableInterviewDates;
import tamanna.challange.interviews.model.Slot;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Interviewer extends Person{
    @OneToMany(mappedBy = "interviewer")
    @JsonIgnore
    private List<Slot> slot;

    @OneToMany(mappedBy = "interviewer")
    private List<AvailableInterviewDates> availableDates;

}
