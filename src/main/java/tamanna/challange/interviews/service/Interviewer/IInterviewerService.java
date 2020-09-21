package tamanna.challange.interviews.service.Interviewer;

import tamanna.challange.interviews.model.Schedule.AvailableInterviewDates;
import tamanna.challange.interviews.model.Person.Interviewer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IInterviewerService {

    List<Interviewer> getAll();

    Optional<Interviewer> getInterviewerById(Integer interviewerId);

    void setInterviewerAvailableDates(Integer interviewerId, List<LocalDateTime> availableDates);

    void insertInterviewer(Interviewer interviewers);

    List<AvailableInterviewDates> getAvailableDatesByInterviewer(Integer interviewerId);
}
