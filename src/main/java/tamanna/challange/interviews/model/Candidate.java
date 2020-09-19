package tamanna.challange.interviews.model;

import lombok.Data;
import java.util.List;

@Data
public class Candidate extends Person{
    private List<Slot> requestedSlots;
}
