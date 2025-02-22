package com.ttl.ResumeMakerBackend.Repository;

import com.ttl.ResumeMakerBackend.Model.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long>{
}