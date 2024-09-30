package com.example.cabinet.Controller;

import com.example.cabinet.Entity.Report;
import com.example.cabinet.Service.Reportservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Reportcontroller {
    @Autowired
    private Reportservice reportservice;

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getReport(@PathVariable Long id) {
        try {
            Report report = reportservice.getReport(id);
            byte[] content = ((Report) report).getContent();

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + report.getTitle() + ".pdf");
            headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");

            return new ResponseEntity<>(content, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}