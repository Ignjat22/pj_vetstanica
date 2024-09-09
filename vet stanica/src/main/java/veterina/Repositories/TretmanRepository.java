package veterina.Repositories;

import veterina.Models.Tretman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TretmanRepository extends JpaRepository <Tretman, Long> {
}
