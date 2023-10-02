package core.domain.users;

import core.domain.Application;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class PasswordEncoder {

    private final byte[] salt = new byte[16];      // used to generate hashed password (should be different for each hash)

    protected PasswordEncoder(){
        // generate a random sequence of characters
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
    }

    protected byte[] encode(final String password)  {

        // defines key specifications associated to hashing algorithm
        KeySpec key_specifications = new PBEKeySpec(password.toCharArray(), salt, Application.settings().getHashAlgorithmStrength(), Application.settings().getHashKeyLenght());
        SecretKeyFactory key_factory;
        try {
            key_factory = SecretKeyFactory.getInstance(Application.settings().getHashingAlgorithm());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error creating hashing keys!");
        }
        try {
            return key_factory.generateSecret(key_specifications).getEncoded();
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("Error running hashing algorithm!");
        }
    }

}
