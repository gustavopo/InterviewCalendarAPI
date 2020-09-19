package tamanna.challange.interviews.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Candidate extends Person{
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany
    private List<Slot> requestedSlots;
}
