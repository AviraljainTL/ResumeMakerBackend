package com.ttl.ResumeMakerBackend.Repository;

import com.ttl.ResumeMakerBackend.Model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}