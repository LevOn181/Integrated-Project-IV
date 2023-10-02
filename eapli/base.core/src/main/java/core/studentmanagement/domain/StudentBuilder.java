package core.studentmanagement.domain;

import core.studentmanagement.domain.Student;
import core.studentmanagement.domain.StudentMechanographicNumber;
import eapli.framework.domain.model.DomainFactory;

import java.time.LocalDate;

/**
 * A builder of the student
 * @author Gabriel Brás Ferreira
 */

public class StudentBuilder implements DomainFactory<Student> {

    private StudentMechanographicNumber mechanographicNumber;
    private String name;
    private LocalDate dateOfBirth;
    private long taxPayerNumber;
    private boolean active;

    public StudentBuilder mechanographicNumber(final StudentMechanographicNumber mechanographicNumber){
        this.mechanographicNumber = mechanographicNumber;
        return this;
    }

    public StudentBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder dateOfBirth(final LocalDate dateOfBirth){
        this.dateOfBirth= dateOfBirth;
        return this;
    }

    public StudentBuilder taxPayerNumber(final long taxPayerNumber) {
        this.taxPayerNumber = taxPayerNumber;
        return this;
    }

    public StudentBuilder active(final boolean active) {
        this.active = active;
        return this;
    }

    public Student build(){
        return new Student(this.mechanographicNumber, this.name, this.dateOfBirth, this.taxPayerNumber, this.active);
    }
}
