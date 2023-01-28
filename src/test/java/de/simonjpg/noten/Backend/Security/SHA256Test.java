package de.simonjpg.noten.Backend.Security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SHA256Test {
    @Test
    void hash() {
        // given
        SHA256 algorithm = new SHA256();
        String plaintext = "SuperSecretPassword";

        // when
        String hash = algorithm.hash(plaintext);

        // then
        assertEquals(algorithm.hash("SuperSecretPassword"), hash);
    }
}