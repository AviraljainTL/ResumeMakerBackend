package com.ttl.ResumeMakerBackend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean fresher_status;
    private String Industry;
    private String company;
    private String position;
    private int yearsOfExperience;
    private String experience;
    @ManyToOne
    @JoinColumn(name = "applicant_id", nullable = false)
    @JsonIgnore
    private Applicant applicant;
}