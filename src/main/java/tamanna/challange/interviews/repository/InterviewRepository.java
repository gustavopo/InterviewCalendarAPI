package tamanna.challange.interviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tamanna.challange.interviews.model.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview,Integer> {
    @Query(value = "SELECT * FROM INTERVIEW WHERE CANDIDATE_ID = :candidateId ", nativeQuery=true)
    Interview findByCandidateId(@Param("candidateId") Long candidateId);
}
