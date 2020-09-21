package tamanna.challange.interviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tamanna.challange.interviews.model.Schedule.AvailableInterviewDates;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AvailableInterviewDatesRepository extends JpaRepository<AvailableInterviewDates,Integer> {
            @Query(value = "SELECT * FROM AVAILABLE_INTERVIEW_DATES WHERE INTERVIEWER_ID = :interviewerId ", nativeQuery=true )
            List<AvailableInterviewDates> getAvailableDatesByInterviewer(Integer interviewerId);

            @Query(value = "SELECT * FROM AVAILABLE_INTERVIEW_DATES WHERE AVAILABLE_DATE > SYSDATE AND AVAILABLE_DATE= :requestedDate ")
            List<AvailableInterviewDates> checkAvailabilityForDate(LocalDateTime requestedDate);
}
    //where employee_date_hired > to_date('31-DEC-95','DD-MON-YY')