package tamanna.challange.interviews.service.Interviewer;

import tamanna.challange.interviews.model.Interviewer;
import tamanna.challange.interviews.model.Slot;

import java.util.List;
import java.util.Optional;

public interface IInterviewerService {

    List<Interviewer> getAll();

    Optional<Interviewer> getInterviewerById(Integer interviewerId);

    List<Slot>getAvailableSlots(Integer interviewerId);

    void insertInterviewer(Interviewer interviewers);

    void setInterviewerSlot(Integer interviewerId);
}
