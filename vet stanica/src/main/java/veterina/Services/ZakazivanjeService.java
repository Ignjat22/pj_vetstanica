package veterina.Services;

import veterina.Models.Zakazivanje;
import veterina.Repositories.ZakazivanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZakazivanjeService {
    @Autowired
    ZakazivanjeRepository zakazivanjeRepository;

    public List<Zakazivanje> getAllZakazivanja() {
        return zakazivanjeRepository.findAll();
    }

    public Zakazivanje addZakazivanje(Zakazivanje zakazivanje) {
        return zakazivanjeRepository.save(zakazivanje);
    }

    public Optional<Zakazivanje> getZakazivanjeByID(Long id) {
        return zakazivanjeRepository.findById(id);
    }

    public void updateZakazivanje(Zakazivanje zakazivanje, Long id) {
        Optional<Zakazivanje> zakazivanjeOptional = zakazivanjeRepository.findById(id);

        if (zakazivanjeOptional.isPresent()) {
            Zakazivanje oldZakazivanje = zakazivanjeOptional.get();
            oldZakazivanje.setDatum(zakazivanje.getDatum());
            oldZakazivanje.setPacijentIme(zakazivanje.getPacijentIme());
            oldZakazivanje.setVeterinarIme(zakazivanje.getVeterinarIme());
            oldZakazivanje.setVrstaTretmana(zakazivanje.getVrstaTretmana());
            zakazivanjeRepository.save(oldZakazivanje);
        }
    }

    public void removeZakazivanjeByID(Long id) {
        zakazivanjeRepository.deleteById(id);
    }
}
