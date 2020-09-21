package tamanna.challange.interviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tamanna.challange.interviews.model.Person.Candidate;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Integer> {
    @Override
    public List<Candidate> findAll() ;

    public Optional<Candidate> getById(Integer integer) ;

    //void getCandidateRequestSlot(Integer candidateId);
}
