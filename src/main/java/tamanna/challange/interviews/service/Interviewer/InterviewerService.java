package tamanna.challange.interviews.service.Interviewer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tamanna.challange.interviews.model.Interviewer;
import tamanna.challange.interviews.model.Slot;
import tamanna.challange.interviews.repository.InterviewerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewerService implements IInterviewerService{

    @Autowired
    private InterviewerRepository interviewerRepository;

    @Override
    public List<Interviewer> getAll() {
        return interviewerRepository.findAll();
    }

    @Override
    public Optional<Interviewer> getById(Integer interviewerId) {
        return interviewerRepository.getById(interviewerId);
    }

    @Override
    public List<Slot> getAvailableSlots(Interviewer interviewer) {
        return interviewerRepository.getSlotsByInterviewer(interviewer);
    }
}
