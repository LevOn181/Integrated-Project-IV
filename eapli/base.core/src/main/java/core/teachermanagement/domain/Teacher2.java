package core.teachermanagement.domain;

import core.teachermanagement.dto.TeacherDTO;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.strings.util.StringPredicates;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Teacher2 extends Acronym implements DTOable<TeacherDTO>{

    @Id
    private Acronym acronym;
    private String name;
    @Column(columnDefinition = "DATE")
    private LocalDate dateOfBirth;
    private long taxPayerNumber;
    public boolean active;

    public Teacher2(Acronym acronym, String name, LocalDate dateOfBirth, long taxPayerNumber, boolean active) {

        if (acronym == null) {
            throw new IllegalArgumentException();
        }

        if (StringPredicates.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Teacher name shouldn't be null or empty.");
        }

        if (dateOfBirth == null) {
            throw new IllegalArgumentException("Date of birth shouldn't be null or empty.");
        }

        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("The date of birth should be before than this current date.");
        }

        if (taxPayerNumber != 9) {
            throw new IllegalArgumentException("Tax payer number should be exactly 9 digits.");
        }

        this.acronym = acronym;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.taxPayerNumber = taxPayerNumber;
        this.active = active;
    }

    protected Teacher2(){
        //ORM only
    }

    @Override
    public boolean equals(final Object o){return DomainEntities.areEqual((DomainEntity<?>) this, o);}

    @Override
    public int hashCode(){return DomainEntities.hashCode((DomainEntity<?>) this);}

    @Override
    public boolean sameAs(final Object two) {
        if (!(two instanceof Teacher2)) {
            return false;
        }

        final Teacher2 one = (Teacher2) two;
        if (this == one) {
            return true;
        }

        return acronym().equals(one.acronym()) && name().equals(one.name)
                && dateOfBirth().equals(one.dateOfBirth) && (taxPayerNumber() == (one.taxPayerNumber)) && active() == one.active;
    }

    @Override
    public Acronym acronym(){return this.acronym;}
    public String name() {return this.name;}
    public LocalDate dateOfBirth() {return this.dateOfBirth;}
    public long taxPayerNumber() {return this.taxPayerNumber;}
    public boolean active(){return this.active;}

    @Override
    public TeacherDTO toDTO() {
        return new TeacherDTO(acronym, name, dateOfBirth, taxPayerNumber, active);
    }

}