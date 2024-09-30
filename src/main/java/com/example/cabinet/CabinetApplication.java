package com.example.cabinet;

import com.example.cabinet.Entity.Medecin;
import com.example.cabinet.Entity.Patient;
import com.example.cabinet.Entity.RDV;
import com.example.cabinet.Entity.Report;
import com.example.cabinet.Repository.MedecinRepo;
import com.example.cabinet.Repository.PatientRepo;
import com.example.cabinet.Repository.RDVRepo;
import com.example.cabinet.Repository.ReportRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CabinetApplication {

	public static void main(String[] args) {

		ApplicationContext context=  SpringApplication.run(CabinetApplication.class, args);
        MedecinRepo medecinRepo = context.getBean(MedecinRepo.class);
		PatientRepo patientRepo = context.getBean(PatientRepo.class);
		RDVRepo rdvRepo = context.getBean(RDVRepo.class);
		ReportRepo reportRepo = context.getBean(ReportRepo.class);

		System.out.println(medecinRepo);
		System.out.println(patientRepo);
		System.out.println(rdvRepo);
		System.out.println(reportRepo);

		medecinRepo.save(Medecin.builder().nom("Bencheqroun").build());
		medecinRepo.save(Medecin.builder().nom("Sahmoudi").build());
		patientRepo.save(Patient.builder().nom("simhamed").build());
		rdvRepo.save(RDV.builder().id(1L).build());
		reportRepo.save(Report.builder().title("Cardio").id(1L).build());

	medecinRepo.findAll().forEach(et->{
		System.out.println(et.toString());
			});

		patientRepo.findAll().forEach(et->{
			System.out.println(et.toString());
		});
		rdvRepo.findAll().forEach(et->{
			System.out.println(et.toString());
		});
		reportRepo.findAll().forEach(et->{
			System.out.println(et.toString());
		});



	}

}
