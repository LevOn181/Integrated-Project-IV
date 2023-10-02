package core.domain;

import eapli.framework.strings.util.StringPredicates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/* Value Object represents a date in the system (has no aggregate) */

public class AppDate implements Comparable<AppDate> {

    final private Date date;

    public AppDate(){
        this.date = new Date();
    }

    public AppDate(final String date){
        if(validate(date))
            this.date = new Date(date);
        else
            throw new IllegalArgumentException("Invalid date format!");
    }

    public AppDate(final int year,final int month, final int day){
        if (validate(String.valueOf(year + '/' + month + '/' + day)))
            this.date = new Date(year, month, day);
        else
            throw new IllegalArgumentException("Invalid date format!");
    }

    private boolean validate(final String date){
        if(StringPredicates.isNullOrWhiteSpace(date))
            return false;
        final DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        dateFormatter.setLenient(false);
        try{
            dateFormatter.parse(date);
        }
        catch (ParseException e){
            return false;
        }
        return true;
    }

    public Date value(){ return this.date; }

    @Override
    public int compareTo(final AppDate otherDate) {
        return this.date.compareTo(otherDate.value());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppDate appDate = (AppDate) o;
        return date.equals(appDate.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return this.date.toString();
    }
}

