package tamanna.challange.interviews.model;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Slot {
    private LocalDate day;
    private LocalDateTime time;
}
