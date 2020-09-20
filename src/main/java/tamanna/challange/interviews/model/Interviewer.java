package tamanna.challange.interviews.model;

import lombok.Data;
import java.util.List;
import javax.persistence.*;

@Data
@Entity
public class Interviewer extends Person{
    @ManyToOne
    private Slot slot;
}
