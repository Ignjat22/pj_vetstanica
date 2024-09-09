package veterina.Controllers;

import org.slf4j.LoggerFactory;
import veterina.Models.Pacijent;
import veterina.Services.PacijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController

public class PacijentController {
    private static final Logger logger = Logger.getLogger(PosetaController.class.getName());


    @Autowired
    private PacijentService pacijentService;

    @RequestMapping(method = RequestMethod.GET, value = "/pacijent")
    public List<Pacijent> getAllPacijenti() {
        logger.log(Level.INFO, "Primljen zahtev za preuzimanje svih pacijenata.");
        try {
            List<Pacijent> pacijenti = pacijentService.getAllPacijenti();
            logger.log(Level.INFO, "Uspešno preuzeti svi pacijenti. Ukupan broj: " + pacijenti.size());
            return pacijenti;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Greška prilikom preuzimanja pacijenata: " + e.getMessage(), e);
            throw e;
        }
    }
    @GetMapping("/pacijent/{id}")
    public ResponseEntity<Pacijent> getPacijentById(@PathVariable int id) {
        Optional<Pacijent> pacijent = pacijentService.getPacijentById(id);
        return pacijent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/pacijent/create")
    public Pacijent addPacijent(@RequestBody Pacijent pacijent) {
        logger.log(Level.INFO, "Primljen zahtev za dodavanje pacijenta: " + pacijent.toString());
        try {
            Pacijent noviPacijent = pacijentService.addPacijent(pacijent);
            logger.log(Level.INFO, "Uspešno dodat pacijent: " + noviPacijent.toString());
            return noviPacijent;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Greška prilikom dodavanja pacijenta: " + e.getMessage(), e);
            throw e; // Ili vraćanje prilagođene greške u odgovoru
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pacijent> updatePacijent(@PathVariable int id, @RequestBody Pacijent pacijent) {
        try {
            Pacijent updatedPacijent = pacijentService.updatePacijent(id, pacijent);
            return ResponseEntity.ok(updatedPacijent);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePacijent(@PathVariable int id) {
        pacijentService.deletePacijent(id);
        return ResponseEntity.noContent().build();
    }
}
/*
{
    "ime": "Rex",
    "vrsta": "Pas",
    "rasa": "Labrador",
    "godinaRodjenja": "1970-01-01T00:00:02.000+00:00",
    "imeVlasnika": "Marko Markovic",
    "kontaktVlasnika": "+38160000000",
    "veterinarId": 1
}

 */