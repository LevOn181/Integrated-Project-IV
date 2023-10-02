package core.domain;

import eapli.framework.strings.util.StringPredicates;
import java.time.format.DateTimeParseException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.time.LocalTime;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Objects;

public class AppDateTime implements Comparable<AppDateTime>{

    final private Date dateTime;
    public AppDateTime(final int year,final int month,final int day,final int hour,final int min,final int sec){
        if (validateDate(String.valueOf(year + '/' + month + '/' + day)) && validateTime(String.valueOf(hour + ':' + min + ':' + sec)))
            this.dateTime = new Date(year, month, day, hour, min, sec);
        else
            throw new IllegalArgumentException("Invalid date or time format!");
    }

    private boolean validateDate(final String date){
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

    private boolean validateTime(final String time){
        if (StringPredicates.isNullOrWhiteSpace(time))
            return false;
        final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss").withResolverStyle(ResolverStyle.STRICT);
        try{
            LocalTime.parse(time, timeFormatter);
        }
        catch (DateTimeParseException e){
            return false;
        }
        return true;
    }

    public Date value(){ return this.dateTime; }

    @Override
    public int compareTo(final AppDateTime otherDateTime) {
        return this.dateTime.compareTo(otherDateTime.value());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppDateTime that = (AppDateTime) o;
        return dateTime.equals(that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime);
    }

    @Override
    public String toString() {
        return this.dateTime.toString();
    }
}

