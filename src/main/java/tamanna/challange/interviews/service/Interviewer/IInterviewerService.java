package tamanna.challange.interviews.service.Interviewer;

import tamanna.challange.interviews.model.Schedule.AvailableInterviewDates;
import tamanna.challange.interviews.model.Person.Interviewer;

import java.time.LocalDateTime;
import java.util.List;

public interface IInterviewerService {

    List<Interviewer> getAll();

    Interviewer getInterviewerById(Long interviewerId);

    void setInterviewerAvailableDates(Long interviewerId, List<LocalDateTime> availableDates);

    void insertInterviewer(Interviewer interviewers);

    List<AvailableInterviewDates> getAvailableDatesByInterviewer(Long interviewerId);
}
