package core.domain;

import eapli.framework.validations.Preconditions;
import java.util.Objects;

public class Duration implements Comparable<Duration>{
    final private int hrs;
    final private int min;
    final private  int sec;

    public Duration(final int hrs, final int min, final int sec){
        Preconditions.noneNull(hrs,min,sec);
        if(validate(hrs,min,sec)){
            this.hrs = hrs;
            this.min = min;
            this.sec = sec;
        }
        else throw new IllegalArgumentException("Duration is Invalid.");
    }
    private boolean validate (final int hrs,final int min,final int sec){
        return (sec < 60 && sec >= 0) && (min < 60 && min >= 0) && (hrs >= 0);
    }

    @Override public int hashCode(){return Objects.hash(hrs,min,sec);}

    @Override
    public int compareTo(final Duration otherDuration) {
        return Math.toIntExact(this.duration() - otherDuration.duration());
    }
    @Override                             //Duration representation
    public String toString() {
        return "Duration is "+ hrs + "h " + min + "m " + sec + "s \n";
    }

    public long duration(){              //calculates the duration in seconds
        return sec + (min * 60L) + (hrs * 3600L);
    }

}
