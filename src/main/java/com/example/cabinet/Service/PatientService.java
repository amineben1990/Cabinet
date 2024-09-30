package com.example.cabinet.Service;

import com.example.cabinet.Entity.Medecin;
import com.example.cabinet.Entity.Patient;
import com.example.cabinet.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.example.cabinet.Entity.Patient;
import com.example.cabinet.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class PatientService {
        @Autowired
        private PatientRepo patientRepo;

        public List<Patient> getAllPatients() {
            return patientRepo.findAll();
        }
        public Patient savePatient(Patient patient) {
            return patientRepo.save(patient);
        }

        public Optional<Patient> findById(Long id) {
            return Optional.empty();
        }
    }


