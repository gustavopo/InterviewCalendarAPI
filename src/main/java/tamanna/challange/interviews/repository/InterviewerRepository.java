package tamanna.challange.interviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tamanna.challange.interviews.model.Person.Interviewer;

import java.util.List;

@Repository
public interface InterviewerRepository extends JpaRepository<Interviewer,Long> {
    @Override
    public List<Interviewer> findAll() ;
}
