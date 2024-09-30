package com.example.cabinet.Repository;

import com.example.cabinet.Entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepo extends JpaRepository<Medecin, Long> {

}
