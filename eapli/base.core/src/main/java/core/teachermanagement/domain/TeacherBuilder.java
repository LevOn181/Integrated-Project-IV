package core.teachermanagement.domain;


import eapli.framework.domain.model.DomainFactory;

import java.time.LocalDate;

public class TeacherBuilder implements DomainFactory<Teacher2> {

    private Acronym acronym;
    private String name;
    private LocalDate dateOfBirth;
    private long taxPayerNumber;
    private boolean active;

    public TeacherBuilder acronym(final Acronym acronym){
        this.acronym = acronym;
        return this;
    }

    public TeacherBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public TeacherBuilder dateOfBirth(final LocalDate dateOfBirth){
        this.dateOfBirth= dateOfBirth;
        return this;
    }

    public TeacherBuilder taxPayerNumber(final long taxPayerNumber) {
        this.taxPayerNumber = taxPayerNumber;
        return this;
    }

    public TeacherBuilder active(final boolean active) {
        this.active = active;
        return this;
    }

    public Teacher2 build(){
        return new Teacher2(this.acronym, this.name, this.dateOfBirth, this.taxPayerNumber, this.active);
    }
}