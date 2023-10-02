package core.teachermanagement.domain;

import eapli.base.Application;
import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;

public class Acronym implements Comparable<Acronym> {

    private final String value;

    protected Acronym(final String acronym){
        if(!validate(acronym))
            throw new IllegalArgumentException("Invalid Acronym!");
        this.value = acronym;
    }

    private boolean validate(final String acronym){
        String regex = "^[A-Z]+$";
        return !StringPredicates.isNullOrWhiteSpace(acronym) && acronym.matches(regex) && acronym.length() <= Application.settings().getAcronymMaxLength();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acronym acronym = (Acronym) o;
        return value.equals(acronym.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public int compareTo(final Acronym a) {
        return this.value.compareTo(a.value);
    }

}

