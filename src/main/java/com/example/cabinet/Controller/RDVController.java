package com.example.cabinet.Controller;

import com.example.cabinet.Entity.Medecin;
import com.example.cabinet.Entity.RDV;
import com.example.cabinet.Repository.MedecinRepo;
import com.example.cabinet.Service.RDVservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RDV")
public class RDVController {
    @Autowired
 private MedecinRepo medecinRepo;

    @Autowired
    private RDVservice rdvService;



 @GetMapping("/{id}")
    public ResponseEntity<List<RDV>> findByidMedecin(@PathVariable Long id) {
        Medecin medecin = medecinRepo.findById(id).orElse(null);
        if (medecin != null) {
            List<RDV> appointments = rdvService.getAppointmentsByMedecin(medecin);
            return ResponseEntity.ok(appointments);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAppointment(@PathVariable Long id, @RequestBody RDV rdv) {
        RDV updatedAppointment = rdvService.updateAppointment(id, rdv);
        if (updatedAppointment != null) {
            return ResponseEntity.ok(updatedAppointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @PostMapping("/appointments/{id}/accept")
    public ResponseEntity<Object> acceptAppointment(@PathVariable Long id) {
        RDV appointment = rdvService.updateAppointment(id, new RDV());
        if (appointment != null) {
            RDV updatedAppointment = rdvService.updateAppointment(id, appointment);
            return ResponseEntity.ok(updatedAppointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
