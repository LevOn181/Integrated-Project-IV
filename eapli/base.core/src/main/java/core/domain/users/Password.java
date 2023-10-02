package core.domain.users;

import eapli.framework.strings.util.StringPredicates;
import org.passay.CharacterRule;
import org.passay.LengthRule;
import org.passay.PasswordGenerator;
import org.passay.Rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* Value Object defines the user's password
 */
public class Password {

    final private PasswordPolicy policy;

    final private PasswordGenerator generator;

    final private PasswordEncoder encoder;

    final private byte [] value;        // encrypted password

    // constructor generates password automatically
    protected Password() {
        generator = new PasswordGenerator();
        encoder = new PasswordEncoder();
        this.policy = new PasswordPolicy();
        try{
            this.value = generateValidPassword();
        }
        catch (RuntimeException e){
            throw new RuntimeException("Error occurred generating password!");
        }
    }

    // constructor generates password automatically with a defined policy
    protected Password(final PasswordPolicy policy) {
        generator = new PasswordGenerator();
        encoder = new PasswordEncoder();
        this.policy = policy;
        try{
            this.value = generateValidPassword();
        }
        catch (RuntimeException e){
            throw new RuntimeException("Error occurred generating password!");
        }
    }

    // constructor creates password with defined text and default rules
    protected Password(final String password) {
        if(StringPredicates.isNullOrWhiteSpace(password))
            throw new IllegalArgumentException("Password cannot be blank!");
        generator = new PasswordGenerator();
        encoder = new PasswordEncoder();
        try{
            this.value = encoder.encode(password);
        }
        catch (RuntimeException e){
            throw new RuntimeException("Error occurred generating password!");
        }
        this.policy = new PasswordPolicy();      // default rules
    }

    // constructor creates password with defined text and defined rules
    protected Password(final String password, final PasswordPolicy policy) {
        if(StringPredicates.isNullOrWhiteSpace(password))
            throw new IllegalArgumentException("Password cannot be blank!");
        generator = new PasswordGenerator();
        encoder = new PasswordEncoder();
        try{
            this.value = encoder.encode(password);
        }
        catch (RuntimeException e){
            throw new RuntimeException("Error occurred generating password!");
        }
        this.policy = policy;
    }

    // checks if a not encoded password (not encrypted) is equal to an encoded password (encrypted)
    protected boolean hashEqualsPassword (final String uncodedPassword) {
        try{
            return Arrays.equals(encoder.encode(uncodedPassword), value);
        }
        catch (RuntimeException e){
            throw new RuntimeException("Error occurred! Password was not hashed successfully!");
        }
    }

    private byte [] generateValidPassword()  {
        int max_length = 20;        // default value is 20
        List<CharacterRule> charRules = new ArrayList<>();
        for (Rule r : policy.value().getRules()){
            if(r instanceof LengthRule)
                max_length = ((LengthRule) r).getMaximumLength();
            if(r instanceof CharacterRule)
                charRules.add((CharacterRule) r);
        }
        try{
            return encoder.encode(generator.generatePassword(max_length, charRules));       // generates a max_length digit password that obeys the defined rules
        }
        catch (RuntimeException e){
            throw new RuntimeException("Error occurred generating password!");
        }
    }

    protected byte [] value() { return this.value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return encoder.equals(password.encoder) && Arrays.equals(value, password.value);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(policy, generator, encoder);
        result = 31 * result + Arrays.hashCode(value);
        return result;
    }

    @Override
    public String toString() {
        return "**********";
    }
}

