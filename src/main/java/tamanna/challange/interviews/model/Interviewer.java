package tamanna.challange.interviews.model;

import lombok.Data;
import java.util.List;

@Data
public class Interviewer extends Person{
    private List<Slot> availableSlots;
}
