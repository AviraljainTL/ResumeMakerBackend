package com.ttl.ResumeMakerBackend.Controller;

import com.ttl.ResumeMakerBackend.Model.Applicant;
import com.ttl.ResumeMakerBackend.Services.ApplicantServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/applicants")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend only
public class ApplicantController {
    private final ApplicantServices applicantService;

    public ApplicantController(ApplicantServices applicantService) {
        this.applicantService = applicantService;
    }

    // 📝 Create a new applicant
    @PostMapping
    public Applicant saveApplicant(@RequestBody Applicant applicant) {
        return applicantService.saveApplicant(applicant);
    }

    // 📄 Get all applications for dashboard
    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants();
    }

    // 🔍 Get application by ID
    @GetMapping("/{id}")
    public Optional<Applicant> getApplicantById(@PathVariable Long id) {
        return applicantService.getApplicantById(id);
    }

    // ✏️ Update existing form
    @PutMapping("/{id}")
    public Applicant updateApplicant(@PathVariable Long id, @RequestBody Applicant updatedApplicant) {
        return applicantService.updateApplicant(id, updatedApplicant);
    }

    // ❌ Delete an application
    @DeleteMapping("/{id}")
    public void deleteApplicant(@PathVariable Long id) {
        applicantService.deleteApplicant(id);
    }

    // 📜 Get JSON data for resume template
    @GetMapping("/{id}/json")
    public String getApplicantJson(@PathVariable Long id) {
        return applicantService.getApplicantJson(id);
    }
}