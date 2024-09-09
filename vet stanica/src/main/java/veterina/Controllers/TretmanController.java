package veterina.Controllers;

import veterina.DTO.TretmanDTO;
import veterina.Models.Tretman;
import veterina.Services.TretmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tretman")
public class TretmanController {
    @Autowired
    private TretmanService tretmanService;

    @GetMapping("/all")
    public ResponseEntity<List<Tretman>> getAllTretmani() {
        List<Tretman> tretmani = tretmanService.getAllTretmani();
        return new ResponseEntity<>(tretmani, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tretman> getTretmanById(@PathVariable Long id) {
        Optional<Tretman> tretman = tretmanService.getTretmanById(id);
        return tretman.isPresent() ? new ResponseEntity<>(tretman.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Tretman> createTretman(@RequestBody Tretman tretman) {
        Tretman createdTretman = tretmanService.addTretman(tretman);
        return new ResponseEntity<>(createdTretman, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tretman> updateTretman(@PathVariable Long id, @RequestBody Tretman tretman) {
        Tretman updatedTretman = tretmanService.updateTretman(id, tretman);
        return updatedTretman != null ? new ResponseEntity<>(updatedTretman, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTretman(@PathVariable Long id) {
        tretmanService.deleteTretman(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
