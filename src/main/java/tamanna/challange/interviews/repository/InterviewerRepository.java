package tamanna.challange.interviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tamanna.challange.interviews.model.Interviewer;
import tamanna.challange.interviews.model.Slot;

import java.util.List;
import java.util.Optional;

@Repository
public interface InterviewerRepository extends JpaRepository<Interviewer,Integer> {
    @Override
    public List<Interviewer> findAll() ;

    List<Slot> getAvailableSlotsByInterviewer(Integer interviewerId);

    void setInterviewerSlot(Integer interviewerId);
}
