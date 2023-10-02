package core.domain.boards.cell;

import core.domain.Application;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;

import java.util.Objects;

public class Row {
    /*
    private final int number;

    private final String title;

    protected Row(final int number, final String title){
        Preconditions.noneNull(number, title);
        if(!validate(number, title))
            throw new IllegalArgumentException("Invalid Row!");
        this.number = number;
        this.title = title;
    }

    private boolean validate(final int number, final String title){
        if(StringPredicates.isNullOrWhiteSpace(title))
            return false;
        return title.length() <= Application.settings().getTitleMaxLength() && number <= Application.settings().getBoardRowMax();
    }

    protected int number(){ return this.number; }

    protected String title(){ return this.title; }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return number == row.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, title);
    }

    @Override
    public String toString() {
        return title();
    }

     */
}
