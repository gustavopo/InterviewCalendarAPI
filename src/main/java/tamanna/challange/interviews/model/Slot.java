package tamanna.challange.interviews.model;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Slot {

    private LocalDate day;
    private LocalDateTime time;

    @OneToMany(mappedBy = "slot")
    private List<Interviewer> interviewer;

    private Candidate candidate;
}
