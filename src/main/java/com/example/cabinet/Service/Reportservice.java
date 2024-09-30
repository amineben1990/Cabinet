package com.example.cabinet.Service;



import com.example.cabinet.Entity.Report;
import com.example.cabinet.Repository.ReportRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class Reportservice {

    @Autowired

    private ReportRepo reportRepo;

    public Report createReport(String title, String reportType, byte[] content) {
        Report report = new Report();
        report.setTitle(title);
        report.setReporttype(reportType);
        report.setContent(content);
        return reportRepo.save(report);
    }
    public Report getReport(Long id) {
        return reportRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Report not found"));
    }
    public byte[] generatePatientReport(Long patientId) throws IOException {
        //  une méthode pour générer le contenu du rapport
        byte[] reportContent = generateReportContent(patientId);

        // Création et sauvegarde du rapport
        Report report = createReport("Patient Report", "PDF", reportContent);

        // Retourne le contenu du rapport
        return report.getContent();
    }

    private byte[] generateReportContent(Long patientId) throws IOException {
        // Implémentation pour générer le contenu du rapport en PDF
        // Utilise iText ou toute autre bibliothèque pour générer le PDF
        return new byte[0]; // Remplace par le vrai contenu généré
    }
}

