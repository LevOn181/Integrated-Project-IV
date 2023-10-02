package core.studentmanagement.dto;

import core.studentmanagement.domain.StudentMechanographicNumber;
import eapli.framework.representations.dto.DTO;

import java.time.LocalDate;

@DTO
public class StudentDTO{

    public StudentMechanographicNumber mechanographicNumber;

    public String name;
    public LocalDate dateOfBirth;
    public long taxPayerNumber;
    public boolean active;

    public StudentDTO(final StudentMechanographicNumber mechanographicNumber, final String name, final LocalDate dateOfBirth, final long taxPayerNumber, final boolean active) {
        this.mechanographicNumber = mechanographicNumber;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.taxPayerNumber = taxPayerNumber;
        this.active = active;
    }

    public StudentDTO(){
        //empty
    }
}