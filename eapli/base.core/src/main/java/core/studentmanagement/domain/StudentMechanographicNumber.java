package core.studentmanagement.domain;


import java.util.Date;
import java.util.Objects;

public class MecanographicNumber implements Comparable<MecanographicNumber>{

    private final String number;



    protected MecanographicNumber(){
        this.number = generateNumber();
    }

    private String sequentialNumber(){

        StringBuilder seqNumber = new StringBuilder();
        seqNumber.append(SequentialNumber.number());
        for (int i = seqNumber.length(); i < 5;i++)
            seqNumber.insert(0, 0);
        return String.valueOf(seqNumber);
    }

    private String currentYear(){
        return String.valueOf(new Date().getYear());
    }

    private String generateNumber(){
        return currentYear() + sequentialNumber();
    }

    @Override
    public String toString() {
        return this.number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MecanographicNumber that = (MecanographicNumber) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(final MecanographicNumber m) {
        return this.number.compareTo(m.number);
    }
}

