package com.ttl.ResumeMakerBackend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkExperienceDTO {

    private boolean fresher_status;
    private String Industry;
    private String company;
    private String position;
    private int yearsOfExperience;
    private int experience;
}
