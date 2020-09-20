package tamanna.challange.interviews.service.Candidate;

import tamanna.challange.interviews.model.Candidate;
import java.util.List;
import java.util.Optional;

public interface ICandidateService {
    List<Candidate> getAll();

    Optional<Candidate> getCandidateById(Integer candidateId);

    void insertCandidates(Candidate candidates);

    //void getCandidateRequestSlot(Integer candidateId);
}
