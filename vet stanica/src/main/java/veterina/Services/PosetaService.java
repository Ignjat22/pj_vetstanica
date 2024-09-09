package veterina.Services;

import veterina.Models.Poseta;
import veterina.Repositories.PosetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosetaService {

    @Autowired
    private PosetaRepository posetaRepository;

    public List<Poseta> getAllPosete() {
        return posetaRepository.findAll();
    }

    public Optional<Poseta> getPosetaById(Long id) {
        return posetaRepository.findById(id);
    }

    public Poseta addPoseta(Poseta poseta) {
        return posetaRepository.save(poseta);
    }

    public Poseta updatePoseta(Long id, Poseta poseta) {
        Optional<Poseta> existingPoseta = posetaRepository.findById(id);
        if (existingPoseta.isPresent()) {
            poseta.setId(id); // Setovanje ID-a na postojeći kako bi se ažurirao ispravan zapis
            return posetaRepository.save(poseta);
        } else {
            throw new IllegalArgumentException("Poseta sa ID " + id + " nije pronađena.");
        }
    }

    public void deletePoseta(Long id) {
        posetaRepository.deleteById(id);
    }
}
