package tamanna.challange.interviews.service.Candidate;

import tamanna.challange.interviews.model.Person.Candidate;
import tamanna.challange.interviews.model.Schedule.RequestedInterviewDates;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ICandidateService {
    List<Candidate> getAll();

    Optional<Candidate> getCandidateById(Long candidateId);

    void insertCandidates(Candidate candidates);

    void setCandidateRequestDates(Long candidateId, List<LocalDateTime> requestDates);

    List<RequestedInterviewDates> getRequestedDatesByCandidate(Long candidateId);
}
