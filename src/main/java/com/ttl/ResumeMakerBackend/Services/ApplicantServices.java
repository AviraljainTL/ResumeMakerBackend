package com.ttl.ResumeMakerBackend.Services;

import com.ttl.ResumeMakerBackend.Model.Applicant;
import com.ttl.ResumeMakerBackend.Repository.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantServices {
    private final ApplicantRepository applicantRepository;

    public ApplicantServices(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public Applicant saveApplicant(Applicant applicant) {
        if (applicant.getId() != null && applicant.getId() == 0) {
            applicant.setId(null); // Prevent Hibernate from using an invalid ID
        }

        // Associate education entries
        if (applicant.getEducationList() != null) {
            applicant.getEducationList().forEach(edu -> edu.setApplicant(applicant));
        }

        // Associate work experience entries
        if (applicant.getWorkExperienceList() != null) {
            applicant.getWorkExperienceList().forEach(work -> work.setApplicant(applicant));
        }

        return applicantRepository.save(applicant);
    }

    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    public Optional<Applicant> getApplicantById(Long id) {
        return applicantRepository.findById(id);
    }

    public Applicant updateApplicant(Long id, Applicant updatedApplicant) {
        return applicantRepository.findById(id)
                .map(existingApplicant -> {
                    existingApplicant.setFirstName(updatedApplicant.getFirstName());
                    existingApplicant.setLastName(updatedApplicant.getLastName());
                    existingApplicant.setPhone(updatedApplicant.getPhone());
                    existingApplicant.setAddress(updatedApplicant.getAddress());
                    existingApplicant.setEmail(updatedApplicant.getEmail());
                    existingApplicant.setEducationList(updatedApplicant.getEducationList());
                    existingApplicant.setWorkExperienceList(updatedApplicant.getWorkExperienceList());
                    return applicantRepository.save(existingApplicant);
                })
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
    }

    public void deleteApplicant(Long id) {
        applicantRepository.deleteById(id);
    }

    public String getApplicantJson(Long id) {
        Optional<Applicant> applicant = applicantRepository.findById(id);
        return applicant.map(Applicant::toString).orElse("{}");
    }
}