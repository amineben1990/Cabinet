package com.example.cabinet.Service;

import com.example.cabinet.Entity.Medecin;
import com.example.cabinet.Repository.MedecinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinService {
    @Autowired
    private MedecinRepo medecinRepo;

    public List<Medecin> getAllMedecins() {
        return medecinRepo.findAll();
    }
    public Medecin saveMedecin(Medecin medecin) {
       return medecinRepo.save(medecin);
    }

    public Optional<Medecin> findById(Long id) {
        return Optional.empty();
    }
}
