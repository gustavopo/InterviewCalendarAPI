package tamanna.challange.interviews.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Candidate extends Person{

    @OneToMany(mappedBy = "candidate")
    private List<Slot> requestedSlots;
}
