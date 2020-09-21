package tamanna.challange.interviews.service.Candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tamanna.challange.interviews.exception.EntityNotFoundException;
import tamanna.challange.interviews.exception.NotValidDateTimeSlotException;
import tamanna.challange.interviews.model.Person.Candidate;
import tamanna.challange.interviews.model.Person.Interviewer;
import tamanna.challange.interviews.model.Schedule.AvailableInterviewDates;
import tamanna.challange.interviews.model.Schedule.RequestedInterviewDates;
import tamanna.challange.interviews.model.Slot;
import tamanna.challange.interviews.repository.AvailableInterviewDatesRepository;
import tamanna.challange.interviews.repository.CandidateRepository;
import tamanna.challange.interviews.repository.RequestedInterviewDatesRepository;
import tamanna.challange.interviews.repository.SlotRepository;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements ICandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private RequestedInterviewDatesRepository requestedInterviewDatesRepository;

    @Autowired
    private AvailableInterviewDatesRepository availableInterviewDatesRepository;
    @Autowired
    private SlotRepository slotRepository;

    @Override
    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Optional<Candidate> getCandidateById(Integer candidateId) {
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
    public void setCandidateRequestDates(Integer candidateId, List<LocalDateTime> requestDates) {
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

    public List<RequestedInterviewDates> getRequestedDatesByCandidate(Integer candidateId) {
        return requestedInterviewDatesRepository.getRequestedDatesByCandidate(candidateId);
    }

    @Override
    public void scheduleInterviewForCandidate(Integer candidateId) {
        Candidate candidate=getCandidateById(candidateId).get();
        List<RequestedInterviewDates> requestedInterviewDatesList =getRequestedDatesByCandidate(candidateId);

        List<AvailableInterviewDates> availableDatesBetween= new LinkedList<>();

        for (RequestedInterviewDates requestedInterview : requestedInterviewDatesList) {
            availableDatesBetween.addAll(availableInterviewDatesRepository.checkAvailabilityForDate(requestedInterview.getRequestedDate()));
        }

        if(!availableDatesBetween.isEmpty())
        {
            //create slot with first interviewer found
            AvailableInterviewDates a = availableDatesBetween.get(0);
            Interviewer interviewer = a.getInterviewer();
            Slot interviewSlot=new Slot();
            interviewSlot.setCandidate(candidate);
            interviewSlot.setInterviewDate(a.getAvailableDate());
            interviewSlot.setInterviewer(interviewer);
            slotRepository.save(interviewSlot);

        }/*else{
            throw new EntityNotFoundException("No compatible dates were found to schedule interview for candidate " + candidateId);
        }*/

    }

}