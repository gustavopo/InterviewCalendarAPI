package tamanna.challange.interviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tamanna.challange.interviews.model.Schedule.AvailableInterviewDates;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AvailableInterviewDatesRepository extends JpaRepository<AvailableInterviewDates,Long> {
            @Query(value = "SELECT * FROM AVAILABLE_INTERVIEW_DATES WHERE INTERVIEWER_ID = :interviewerId ", nativeQuery=true )
            List<AvailableInterviewDates> getAvailableDatesByInterviewer(@Param("interviewerId") Long interviewerId);

            @Query(value = "SELECT * FROM AVAILABLE_INTERVIEW_DATES WHERE to_char(AVAILABLE_DATE, 'YYYY-MM-DD') = to_char( :requestedDate, 'YYYY-MM-DD')" ,
                    nativeQuery = true)
            List<AvailableInterviewDates> checkAvailabilityForDate(@Param("requestedDate") LocalDateTime requestedDate);
}