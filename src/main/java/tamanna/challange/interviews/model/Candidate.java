package tamanna.challange.interviews.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Candidate extends Person{
    @Id
    @GeneratedValue
    private Integer id;

    private List<Slot> requestedSlots;
}
