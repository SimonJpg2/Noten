package de.simonjpg.noten.Backend.Security;

import java.security.NoSuchAlgorithmException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.security.MessageDigest.getInstance;

/**
 * Class SHA256.
 *
 * <p>
 *     This Class contains logic to hash user credentials.
 * </p>
 *
 * @version 1.0
 * @since 28.1.2023
 * @author SimonJpg
 */

public class SHA256 {
    /**
     * Method hash.
     *
     * <p>
     *     Hashes the plaintext using the SHA256 algorithm.
     * </p>
     *
     * @param plaintext the plaintext to hash.
     * @return the hash as a String.
     * @throws java.lang.RuntimeException if algorithm not found.
     */
    public String hash(String plaintext) {
        byte[] plaintextBytes = plaintext.getBytes(UTF_8);

        try {
            return new String(getInstance("SHA-256").digest(plaintextBytes));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Encryption failed: " + e); //TODO: replace with custom exception
        }
    }
}
