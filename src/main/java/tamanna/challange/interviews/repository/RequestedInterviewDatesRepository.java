package tamanna.challange.interviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tamanna.challange.interviews.model.Schedule.RequestedInterviewDates;

import java.util.List;

@Repository
public interface RequestedInterviewDatesRepository extends JpaRepository<RequestedInterviewDates,Long> {
    @Query(value = "SELECT * FROM REQUESTED_INTERVIEW_DATES WHERE CANDIDATE_ID = :candidateId ", nativeQuery=true )
    List<RequestedInterviewDates> getRequestedDatesByCandidate(@Param("candidateId") Long candidateId);

}
