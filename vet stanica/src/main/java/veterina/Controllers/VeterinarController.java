package veterina.Controllers;

import veterina.DTO.VeterinarDTO;
import veterina.Models.Veterinar;
import veterina.Services.VeterinarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veterinar")
public class VeterinarController {
    @Autowired
    private VeterinarService veterinarService;

    @GetMapping("/all")
    public List<Veterinar> getAllVeterinari() {
        return veterinarService.getAllVeterinari();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinar> getVeterinarById(@PathVariable int id) {
        Optional<Veterinar> veterinar = veterinarService.getVeterinarById(id);
        return veterinar.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Veterinar addVeterinar(@RequestBody Veterinar veterinar) {
        return veterinarService.addVeterinar(veterinar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinar> updateVeterinar(@PathVariable int id, @RequestBody Veterinar veterinar) {
        try {
            Veterinar updatedVeterinar = veterinarService.updateVeterinar(id, veterinar);
            return ResponseEntity.ok(updatedVeterinar);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeterinar(@PathVariable int id) {
        veterinarService.deleteVeterinar(id);
        return ResponseEntity.noContent().build();
    }
}
/*

 */