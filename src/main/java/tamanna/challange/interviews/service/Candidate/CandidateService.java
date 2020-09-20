package tamanna.challange.interviews.service.Candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tamanna.challange.interviews.model.Candidate;
import tamanna.challange.interviews.model.Interviewer;
import tamanna.challange.interviews.model.Slot;
import tamanna.challange.interviews.repository.CandidateRepository;
import tamanna.challange.interviews.repository.InterviewerRepository;
import tamanna.challange.interviews.service.Interviewer.IInterviewerService;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements ICandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Optional<Candidate> getCandidateById(Integer candidateId) {
        return candidateRepository.findById(candidateId);
    }

    @Override
    public void insertCandidates(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    /*@Override
    public void getCandidateRequestSlot(Integer candidateId) {
        candidateRepository.getCandidateRequestSlot(candidateId);
    }*/

}