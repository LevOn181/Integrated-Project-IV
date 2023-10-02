package core.domain.users;

import eapli.framework.strings.util.StringPredicates;
import java.util.Objects;

public class UserName implements Comparable<UserName> {

    final private String shortName;
    final private  String fullName;

    protected UserName (final String shortName,final String fullName){
        if(!validate(shortName,fullName))
            throw new IllegalArgumentException("Invalid Name");
        this.shortName = shortName;
        this.fullName = fullName;
    }

    private boolean validate(final String shortName,final String fullName){
        return !StringPredicates.isNullOrWhiteSpace(shortName) && !StringPredicates.isNullOrWhiteSpace(fullName)
                && !StringPredicates.containsDigit(shortName) && !StringPredicates.containsDigit(fullName);
    }
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return shortName.equals(userName.shortName) && fullName.equals(userName.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortName, fullName);
    }
    @Override
    public String toString() {
        return "User's full name: "+fullName+"\n User's short name: " +shortName + "\n";
    }
    protected String shortName(){
        return this.shortName;
    }
    protected String fullName(){
        return this.fullName;
    }
    @Override
    public int compareTo(final UserName otherName) {
        return this.fullName.compareTo(otherName.fullName());
    }

}
