package com.example.cabinet.Repository;

import com.example.cabinet.Entity.Medecin;
import com.example.cabinet.Entity.Patient;
import com.example.cabinet.Entity.RDV;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RDVRepo extends JpaRepository<RDV, Long> {

    List<RDV> findByMedecinId(Long medecin);


    List<RDV> findByPatientId(Long patient);
}
