package tamanna.challange.interviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tamanna.challange.interviews.model.Schedule.AvailableInterviewDates;

import java.util.List;

@Repository
public interface AvailableInterviewDatesRepository extends JpaRepository<AvailableInterviewDates,Long> {
            @Query(value = "SELECT * FROM AVAILABLE_INTERVIEW_DATES WHERE INTERVIEWER_ID = :interviewerId ", nativeQuery=true )
            List< AvailableInterviewDates > getAvailableDatesByInterviewer(Long interviewerId);
}
