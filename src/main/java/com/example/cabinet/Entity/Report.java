package com.example.cabinet.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String reporttype;
    @Lob
    private byte[] content;

}



