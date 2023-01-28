package de.simonjpg.noten.Backend.Security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
        byte[] plaintextBytes = plaintext.getBytes(StandardCharsets.UTF_8);

        try {
            return new String(MessageDigest.getInstance("SHA-256").digest(plaintextBytes));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Encryption failed: " + e);
        }
    }
}
