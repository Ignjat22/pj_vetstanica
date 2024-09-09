package veterina.Repositories;

import veterina.Models.Zakazivanje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZakazivanjeRepository extends JpaRepository<Zakazivanje, Long> {
}
