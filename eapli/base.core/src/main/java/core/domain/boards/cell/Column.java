package core.domain.boards.cell;

import core.domain.Application;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;

import java.util.Objects;

public class Column {
    /*
    private final int number;

    private final String title;

    protected Column(final int number, final String title){
        Preconditions.noneNull(number, title);
        if(!validate(number, title))
            throw new IllegalArgumentException("Invalid Row!");
        this.number = number;
        this.title = title;
    }

    private boolean validate(final int number, final String title){
        if(StringPredicates.isNullOrWhiteSpace(title))
            return false;
        return title.length() <= Application.settings().getTitleMaxLength() && number <= Application.settings().getBoardColumnMax();
    }

    protected int number(){ return this.number; }

    protected String title(){ return this.title; }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return number == column.number && title.equals(column.title);
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
