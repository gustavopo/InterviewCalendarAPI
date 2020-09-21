package tamanna.challange.interviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tamanna.challange.interviews.model.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot,Integer> {
}
