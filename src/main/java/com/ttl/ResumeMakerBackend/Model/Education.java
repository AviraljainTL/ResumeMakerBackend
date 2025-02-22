package com.ttl.ResumeMakerBackend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String degree;
    private String course;
    private String institution;
    private int yearOfCompletion;

    @ManyToOne
    @JoinColumn(name = "applicant_id", nullable = false)
    @JsonIgnore
    private Applicant applicant;
}