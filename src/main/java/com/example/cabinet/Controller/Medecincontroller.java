package com.example.cabinet.Controller;

import com.example.cabinet.Entity.Medecin;
import com.example.cabinet.Service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Medicine")
public class Medecincontroller {
    @Autowired
    private MedecinService medecinService;

    @PostMapping
    public ResponseEntity<Medecin> createMedecin(@RequestBody Medecin medecin) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medecin> getMedecinById(@PathVariable Long id) {
        Optional<Medecin> optionalMedecin = medecinService.findById(id);  
        return optionalMedecin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
