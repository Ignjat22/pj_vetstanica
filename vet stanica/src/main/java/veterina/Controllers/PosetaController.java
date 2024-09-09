package veterina.Controllers;

import veterina.DTO.PosetaDTO;
import veterina.Models.Poseta;
import veterina.Services.PosetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/poseta")
public class PosetaController {

    @Autowired
    private PosetaService posetaService;

    @GetMapping("/all")
    public List<Poseta> getAllPosete() {
        return posetaService.getAllPosete();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poseta> getPosetaById(@PathVariable Long id) {
        Optional<Poseta> poseta = posetaService.getPosetaById(id);
        return poseta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Poseta addPoseta(@RequestBody Poseta poseta) {
        return posetaService.addPoseta(poseta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Poseta> updatePoseta(@PathVariable Long id, @RequestBody Poseta poseta) {
        try {
            Poseta updatedPoseta = posetaService.updatePoseta(id, poseta);
            return ResponseEntity.ok(updatedPoseta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoseta(@PathVariable Long id) {
        posetaService.deletePoseta(id);
        return ResponseEntity.noContent().build();
    }
}
