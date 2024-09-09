package veterina.Repositories;

import veterina.Models.Veterinar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarRepository extends JpaRepository<Veterinar, Integer> {

}