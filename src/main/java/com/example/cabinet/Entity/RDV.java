package com.example.cabinet.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RDV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Medecin medecin;

    private Date date;

    @Override
    public String toString() {
        return "RDV{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}


