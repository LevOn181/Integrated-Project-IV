package core.domain.users;

import org.passay.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PasswordPolicy {

    private final PasswordValidator validator;

    protected PasswordPolicy(){
        validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 20),                              //minimum lenght of 8 and maximum of 20
                new CharacterRule(EnglishCharacterData.Digit),      //1 digit
                new CharacterRule(EnglishCharacterData.Special),    //have at least 1 special character
                new CharacterRule(EnglishCharacterData.LowerCase),  //have at least 1 lower case letter
                new CharacterRule(EnglishCharacterData.UpperCase)   //have at least 1 upper case letter
        ));
    }

    // creates policy with a list of defined rules
    protected PasswordPolicy(final List<Rule> rules){
        if(rules.isEmpty())
            throw new IllegalArgumentException("Policy needs to have at least one rule!");
        validator = new PasswordValidator(rules);
    }

    protected boolean checkPassword(final String password){
        RuleResult policyResult = validator.validate(new PasswordData(password));
        return policyResult.isValid();
    }

    protected PasswordValidator value (){ return validator; }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordPolicy that = (PasswordPolicy) o;
        return validator.equals(that.validator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(validator);
    }

    @Override
    public String toString() {
        return validator.toString();
    }
}

