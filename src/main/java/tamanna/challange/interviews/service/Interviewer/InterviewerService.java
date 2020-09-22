package tamanna.challange.interviews.service.Interviewer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tamanna.challange.interviews.exception.EntityNotFoundException;
import tamanna.challange.interviews.exception.NotValidDateTimeSlotException;
import tamanna.challange.interviews.model.Schedule.AvailableInterviewDates;
import tamanna.challange.interviews.model.Person.Interviewer;
import tamanna.challange.interviews.repository.AvailableInterviewDatesRepository;
import tamanna.challange.interviews.repository.InterviewerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InterviewerService implements IInterviewerService{

    @Autowired
    private InterviewerRepository interviewerRepository;
    
    @Autowired
    private AvailableInterviewDatesRepository availableInterviewDatesRepository;

    @Override
    public List<Interviewer> getAll() {
        return interviewerRepository.findAll();
    }

    @Override
    public Optional<Interviewer> getInterviewerById(Long interviewerId) {

        Optional<Interviewer> interviewer =  interviewerRepository.findById(interviewerId);
        if(!interviewer.isPresent())
        {
            throw new EntityNotFoundException("Not found Interviewer with Id:"+interviewerId);
        }
        return interviewer;
    }

    @Override
    public void insertInterviewer(Interviewer interviewer) {
    interviewerRepository.save(interviewer);
    }

    @Override
    public void setInterviewerAvailableDates(Long interviewerId, List<LocalDateTime> availableDates) {
        for (LocalDateTime date: availableDates) {
            if(date.isAfter(LocalDateTime.now()))
            {
                if(date.getMinute()==0) {
                    AvailableInterviewDates aid = new AvailableInterviewDates();
                    aid.setInterviewer(getInterviewerById(interviewerId).get());
                    aid.setAvailableDate(date);
                    availableInterviewDatesRepository.save(aid);
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

    public List<AvailableInterviewDates> getAvailableDatesByInterviewer(Long interviewerId) {
        return availableInterviewDatesRepository.getAvailableDatesByInterviewer(interviewerId);
    }

}
