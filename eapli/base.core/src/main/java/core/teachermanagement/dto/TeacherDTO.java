package core.teachermanagement.dto;

import core.teachermanagement.domain.Acronym;
import eapli.framework.representations.dto.DTO;

import java.time.LocalDate;

@DTO
public class TeacherDTO{

    public Acronym acronym;
    public String name;
    public LocalDate dateOfBirth;
    public long taxPayerNumber;
    public boolean active;

    public TeacherDTO(final Acronym acronym, final String name, final LocalDate dateOfBirth, final long taxPayerNumber, final boolean active) {
        this.acronym = acronym;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.taxPayerNumber = taxPayerNumber;
        this.active = active;
    }

    public TeacherDTO(){
        //empty
    }
}