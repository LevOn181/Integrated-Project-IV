package core.domain;

import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;

/* Value Object represents a user's tax number in the system (has no aggregate)
 */

public class TaxNumber {

    final private String nif;

    public TaxNumber(final String nif){
        if(validate(nif))
            this.nif = nif;
        else
            throw new IllegalArgumentException("Invalid Tax Number!");
    }

    private boolean validate(final String nif){
        if (StringPredicates.isNullOrWhiteSpace(nif))
            return false;
        return nif.matches("^[0-9]{9}$");
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxNumber taxNumber = (TaxNumber) o;
        return nif.equals(taxNumber.nif);
    }
    @Override
    public String toString() {
        return this.nif;
    }
    @Override
    public int hashCode() {
        return Objects.hash(nif);
    }


}

