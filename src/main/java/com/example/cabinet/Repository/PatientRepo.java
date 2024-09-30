package com.example.cabinet.Repository;

import com.example.cabinet.Entity.Medecin;
import com.example.cabinet.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient, Long> {

}

