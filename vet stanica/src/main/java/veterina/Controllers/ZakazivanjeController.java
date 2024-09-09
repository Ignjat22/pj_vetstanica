package veterina.Controllers;

import veterina.DTO.ZakazivanjeDTO;
import veterina.Models.Zakazivanje;
import veterina.Services.ZakazivanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/zakazivanje")
public class ZakazivanjeController {

    @Autowired
    private ZakazivanjeService zakazivanjeService;

    @GetMapping("/all")
    public List<Zakazivanje> getAllZakazivanja() {
        return zakazivanjeService.getAllZakazivanja();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zakazivanje> getZakazivanjeById(@PathVariable Long id) {
        Optional<Zakazivanje> zakazivanje = zakazivanjeService.getZakazivanjeByID(id);
        return zakazivanje.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Zakazivanje addZakazivanje(@RequestBody Zakazivanje zakazivanje) {
        return zakazivanjeService.addZakazivanje(zakazivanje);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<Zakazivanje> updateZakazivanje(@PathVariable Long id, @RequestBody Zakazivanje zakazivanje) {
        try {
            Zakazivanje updatedZakazivanje = zakazivanjeService.updateZakazivanje(zakazivanje, id);
            return ResponseEntity.ok(updatedZakazivanje);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZakazivanje(@PathVariable Long id) {
        zakazivanjeService.removeZakazivanjeByID(id);
        return ResponseEntity.noContent().build();
    }
}
/*
{
    "datum": "2024-09-05T10:30:00",
    "pacijentIme": "Milos",
    "veterinarIme": "Dr. Jovan",
    "vrstaTretmana": "Vakcinacija"
}
 */
