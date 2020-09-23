package tamanna.challange.interviews.service.Candidate;

import tamanna.challange.interviews.model.Person.Candidate;
import tamanna.challange.interviews.model.Schedule.RequestedInterviewDates;
import tamanna.challange.interviews.model.Interview;

import java.time.LocalDateTime;
import java.util.List;

public interface ICandidateService {
    List<Candidate> getAll();

    Candidate getCandidateById(Long candidateId);

    void insertCandidates(Candidate candidates);

    void setCandidateRequestDates(Long candidateId, List<LocalDateTime> requestDates);

    List<RequestedInterviewDates> getRequestedDatesByCandidate(Long candidateId);

    void scheduleInterviewForCandidate(Long candidateId);

    void rescheduleInterviewForCandidate(Long candidateId, Interview interview);
}
