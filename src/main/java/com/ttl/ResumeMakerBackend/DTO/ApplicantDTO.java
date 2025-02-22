package com.ttl.ResumeMakerBackend.DTO;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApplicantDTO {

        private String phone;
        private String address;
        private String email;
        private List<EducationDTO> educationList;
        private List<WorkExperienceDTO> workExperienceList;
}
