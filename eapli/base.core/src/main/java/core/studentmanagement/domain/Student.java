package core.studentmanagement.domain;

import core.studentmanagement.dto.StudentDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.strings.util.StringPredicates;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@GenericGenerator(name = "StudentMechanographicNumber", strategy = "core.studentmanagement.domain.StudentMechanographicNumber")
public class Student{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "StudentMechanographicNumber")
    private StudentMechanographicNumber mechanographicNumber;

    private String name;

    private LocalDate dateOfBirth;

    private long taxPayerNumber;

    private boolean active;


    public Student(StudentMechanographicNumber mechanographicNumber, String name, LocalDate dateOfBirth, long taxPayerNumber, boolean active){

        if (mechanographicNumber == null)
            throw new IllegalArgumentException();

        if (StringPredicates.isNullOrEmpty(name))
            throw new IllegalArgumentException("Student name shouldn't be null or empty.");

        if (taxPayerNumber != 9)
            throw  new IllegalArgumentException("Tax payer number should be exactly 9 digits.");

        this.mechanographicNumber = mechanographicNumber;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.taxPayerNumber = taxPayerNumber;
        this.active = active;

    }

    protected Student(){
        // ORM only
    }
    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object two) {
        if (!(two instanceof Student)) {
            return false;
        }

        final Student one = (Student) two;
        if (this == one) {
            return true;
        }

        return mechanographicNumber().equals(one.mechanographicNumber) && name().equals(one.name)
                && dateOfBirth().equals(one.dateOfBirth) && (taxPayerNumber() == (one.taxPayerNumber)) && active() == one.active;

    }

    @Override
    public StudentMechanographicNumber mechanographicNumber() {return mechanographicNumber;}

    public String name() {return this.name;}

    public LocalDate dateOfBirth() {return this.dateOfBirth;}

    public long taxPayerNumber() {return this.taxPayerNumber;}

    @Override
    public StudentDTO forDTO(){
        return new StudentDTO(mechanographicNumber, name, dateOfBirth, taxPayerNumber, active);
    }

    public boolean active() {
        return this.active;
    }
    @Override
    public StudentMechanographicNumber identity() {
        return null;
    }
}