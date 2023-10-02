package core.domain.boards.cell;

import eapli.framework.validations.Preconditions;

import java.awt.*;
import java.util.Objects;

public class Cell {

    private final Column column;
    private final Row row;

    protected Cell(final Row row, final Column column){
        Preconditions.noneNull(row, column);
        this.column = column;
        this.row = row;
    }

    protected Point coordinates(){
        return new Point(column.number(), row.number());
    }
    protected Row row(){
        return row;
    }
    protected Column column(){
        return column;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return this.coordinates().equals(cell.coordinates());
    }

    @Override
    public String toString() {
        return coordinates().toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
