package core.domain.users;

import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;

/* Value Object represents the user's email it should be unique for each user */

public class EmailAddress implements Comparable<EmailAddress>{

    final private String email;

    protected EmailAddress(final String email){
        if(validate(email))
            this.email = email;
        else
            throw new IllegalArgumentException("Invalid Email!");
    }

    private boolean validate(final String email){
        return StringPredicates.isEmail(email) && !StringPredicates.isNullOrEmpty(email);     // eapli framework
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAddress that = (EmailAddress) o;
        return email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return this.email;
    }

    @Override
    public int compareTo(final EmailAddress otherEmail) {
        return this.email.compareTo(otherEmail.email);
    }
}
