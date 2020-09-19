package tamanna.challange.interviews.service.Interviewer;

import tamanna.challange.interviews.model.Interviewer;
import tamanna.challange.interviews.model.Slot;

import java.util.List;
import java.util.Optional;

public interface IInterviewerService {

    List<Interviewer> getAll();

    Optional<Interviewer> getById(Integer interviewerId);

    List<Slot>getAvailableSlots(Interviewer interviewer);
}
