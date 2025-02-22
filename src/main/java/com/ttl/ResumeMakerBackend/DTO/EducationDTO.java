package com.ttl.ResumeMakerBackend.DTO;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducationDTO {

    private String degree;
    private String course;
    private String institution;
    private int yearOfCompletion;

}
