package tamanna.challange.interviews.service.Candidate;

import tamanna.challange.interviews.model.Person.Candidate;
import tamanna.challange.interviews.model.Schedule.RequestedInterviewDates;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ICandidateService {
    List<Candidate> getAll();

    Optional<Candidate> getCandidateById(Integer candidateId);

    void insertCandidates(Candidate candidates);

    void setCandidateRequestDates(Integer candidateId, List<LocalDateTime> requestDates);

    List<RequestedInterviewDates> getRequestedDatesByCandidate(Integer candidateId);

    void scheduleInterviewForCandidate(Integer candidateId);
}
