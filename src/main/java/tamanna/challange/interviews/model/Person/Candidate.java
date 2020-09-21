package tamanna.challange.interviews.model.Person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import tamanna.challange.interviews.model.Schedule.RequestedInterviewDates;
import tamanna.challange.interviews.model.Slot;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Candidate extends Person{

    @OneToMany(mappedBy = "candidate")
    @JsonIgnore
    private List<Slot> requestedSlots;

    @OneToMany(mappedBy = "candidate")
    private List<RequestedInterviewDates> requestedDates;
}
