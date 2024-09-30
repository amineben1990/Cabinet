package com.example.cabinet.Controller;

import com.example.cabinet.Entity.Medecin;
import com.example.cabinet.Entity.Patient;
import com.example.cabinet.Service.MedecinService;
import com.example.cabinet.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Patient")
public class Patientcontroller {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> optionalPatient = patientService.findById(id);
        return optionalPatient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

