package veterina.Services;

import veterina.Models.Pacijent;
import veterina.Models.Veterinar;
import veterina.Repositories.PacijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veterina.Repositories.VeterinarRepository;

import java.util.List;
import java.util.Optional;

    @Service
    public class PacijentService {
        private List<Veterinar> veterinari;


        @Autowired
        private VeterinarRepository veterinarRepository;

        @Autowired
        private PacijentRepository pacijentRepository;

        public List<Pacijent> getAllPacijenti() {
            return pacijentRepository.findAll();
        }

        public Optional<Pacijent> getPacijentById(int id) {
            return pacijentRepository.findById(id);
        }

        public Pacijent addPacijent(Pacijent pacijent) {
            return pacijentRepository.save(pacijent);
        }

        public Pacijent updatePacijent(int id, Pacijent pacijent) {
            return pacijentRepository.findById(id)
                    .map(existingPacijent -> {
                        existingPacijent.setIme(pacijent.getIme());
                        existingPacijent.setVrsta(pacijent.getVrsta());
                        existingPacijent.setRasa(pacijent.getRasa());
                        existingPacijent.setGodinaRodjenja(pacijent.getgodinaRodjenja());
                        existingPacijent.setImeVlasnika(pacijent.getImeVlasnika());
                        existingPacijent.setKontaktVlasnika(pacijent.getKontaktVlasnika());
                        return pacijentRepository.save(existingPacijent);
                    })
                    .orElseThrow(() -> new IllegalArgumentException("Pacijent not found"));
        }

        public void deletePacijent(int id) {
            pacijentRepository.deleteById(id);
        }
        public Pacijent assignVeterinarToPacijent(int pacijentId, int veterinarId) {
            Optional<Pacijent> pacijentOptional = pacijentRepository.findById(pacijentId);
            Optional<Veterinar> veterinarOptional = veterinarRepository.findById(veterinarId);

            if (pacijentOptional.isPresent() && veterinarOptional.isPresent()) {
                Pacijent pacijent = pacijentOptional.get();
                Veterinar veterinar = veterinarOptional.get();

                pacijent.setVeterinar(veterinar); // Pretpostavljam da imaš metodu setVeterinar u Pacijent klasi
                return pacijentRepository.save(pacijent);
            } else {
                throw new IllegalArgumentException("Pacijent or Veterinar not found");
            }
        }
    }

