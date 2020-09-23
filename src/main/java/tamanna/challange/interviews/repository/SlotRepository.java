package tamanna.challange.interviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tamanna.challange.interviews.model.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot,Integer> {
    @Query(value = "SELECT * FROM SLOT WHERE CANDIDATE_ID = :candidateId ", nativeQuery=true)
    Slot findByCandidateId(@Param("candidateId") Long candidateId);
}
