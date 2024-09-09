package veterina.Services;

import veterina.Models.Veterinar;
import veterina.Repositories.VeterinarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarService {

    @Autowired
    private VeterinarRepository veterinarRepository;

    public List<Veterinar> getAllVeterinari() {
        return veterinarRepository.findAll();
    }

    public Optional<Veterinar> getVeterinarById(int id) {
        return veterinarRepository.findById(id);
    }

    public Veterinar addVeterinar(Veterinar veterinar) {
        return veterinarRepository.save(veterinar);
    }

    public Veterinar updateVeterinar(int id, Veterinar veterinar) {
        Optional<Veterinar> existingVeterinar = veterinarRepository.findById(id);
        if (existingVeterinar.isPresent()) {
            veterinar.setId((int) id);
            return veterinarRepository.save(veterinar);
        } else {
            throw new IllegalArgumentException("Veterinar sa ID " + id + " nije pronađen.");
        }
    }

    public void deleteVeterinar(int id) {
        veterinarRepository.deleteById(id);
    }
}