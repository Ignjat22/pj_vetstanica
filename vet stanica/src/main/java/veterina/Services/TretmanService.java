package veterina.Services;

import veterina.DTO.TretmanDTO;
import veterina.Models.Tretman;
//import Models.TretmanDTO;//
import veterina.Repositories.TretmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TretmanService {

    @Autowired
    private TretmanRepository tretmanRepository;

    public List<Tretman> getAllTretmani() {
        return tretmanRepository.findAll();
    }

    public Optional<Tretman> getTretmanById(Long id) {
        return tretmanRepository.findById(id);
    }

    public Tretman addTretman(Tretman tretman) {
        return tretmanRepository.save(tretman);
    }
    public Tretman updateTretman(Long id, Tretman tretman) {
        Optional<Tretman> existingTretman = tretmanRepository.findById(id);
        if (existingTretman.isPresent()) {
            Tretman updatedTretman = existingTretman.get();
            updatedTretman.setOpis(tretman.getOpis());
            updatedTretman.setCena(tretman.getCena());
            updatedTretman.setTrajanje(tretman.getTrajanje());
            return tretmanRepository.save(updatedTretman);
        } else {
            return null;
        }
    }
    public void deleteTretman(Long id) {
        tretmanRepository.deleteById(id);
    }
}