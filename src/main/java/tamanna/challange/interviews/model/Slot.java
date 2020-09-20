package tamanna.challange.interviews.model;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Slot {
    @Id
    @GeneratedValue
    private Integer slotId;

    private LocalDate day;
    private LocalDateTime time;

    @OneToMany(mappedBy = "slot")
    private List<Interviewer> interviewer;

    @ManyToOne
    private Candidate candidate;
}
