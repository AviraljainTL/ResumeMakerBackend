package com.ttl.ResumeMakerBackend.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String email;

    // One-to-Many: Applicant -> Education (Cascades persist but prevents delete cascades)
    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Education> educationList;

    // One-to-Many: Applicant -> WorkExperience
    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WorkExperience> workExperienceList;

}