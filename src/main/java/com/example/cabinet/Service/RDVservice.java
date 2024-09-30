package com.example.cabinet.Service;

import com.example.cabinet.Entity.Medecin;
import com.example.cabinet.Entity.Patient;
import com.example.cabinet.Entity.RDV;
import com.example.cabinet.Repository.RDVRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RDVservice {
    @Autowired
    private RDVRepo rdvRepo;

    public RDV createAppointment(RDV appointment) {

        return rdvRepo.save(appointment);
    }

    public RDV updateAppointment(Long id, RDV appointment) {
        if (rdvRepo.findById(id).isPresent()) {
            appointment.setId(id);
            return rdvRepo.save(appointment);
        }
        return null;
    }


    public List<RDV> getAppointmentsByMedecin(Medecin medecin) {
        return rdvRepo.findByMedecinId(medecin.getId());
    }

    public List<RDV> getAvailableAppointments(Medecin medecin) {


        return rdvRepo.findByMedecinId(medecin.getId());

    }


    public List<RDV> getAppointmentsByPatient(Patient patient) {

        return rdvRepo.findByPatientId(patient.getId());

    }

    public List<RDV> HistoriquedesrendezvsByMedecin(Medecin medecin) {

        return rdvRepo.findByMedecinId(medecin.getId());
    }

}





