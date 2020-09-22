package tamanna.challange.interviews.service.Candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tamanna.challange.interviews.exception.EntityNotFoundException;
import tamanna.challange.interviews.exception.NotValidDateTimeSlotException;
import tamanna.challange.interviews.model.Person.Candidate;
import tamanna.challange.interviews.model.Schedule.RequestedInterviewDates;
import tamanna.challange.interviews.repository.CandidateRepository;
import tamanna.challange.interviews.repository.RequestedInterviewDatesRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements ICandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private RequestedInterviewDatesRepository requestedInterviewDatesRepository;

    @Override
    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Optional<Candidate> getCandidateById(Long candidateId) {
        Optional<Candidate> candidate = candidateRepository.findById(candidateId);
        if(!candidate.isPresent())
        {
            throw new EntityNotFoundException("Not found Candidate with Id: "+candidateId);
        }
        return candidate;
    }

    @Override
    public void insertCandidates(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    @Override
    public void setCandidateRequestDates(Long candidateId, List<LocalDateTime> requestDates) {
        for (LocalDateTime date: requestDates) {
            if(date.isAfter(LocalDateTime.now()))
            {
                if(date.getMinute()==0) {
                    RequestedInterviewDates rid = new RequestedInterviewDates();
                    rid.setCandidate(getCandidateById(candidateId).get());
                    rid.setRequestedDate(date);
                    requestedInterviewDatesRepository.save(rid);
                }else
                {
                    throw  new NotValidDateTimeSlotException("Wrong Time Input!\n Interviews can only be made by the hour. Please enter minutes to 00!");
                }
            }else
            {
                throw  new NotValidDateTimeSlotException("Wrong Date Input!\n The request slot must be in the future!");
            }
        }
    }

    public List<RequestedInterviewDates> getRequestedDatesByCandidate(Long candidateId) {
        return requestedInterviewDatesRepository.getRequestedDatesByCandidate(candidateId);
    }

}