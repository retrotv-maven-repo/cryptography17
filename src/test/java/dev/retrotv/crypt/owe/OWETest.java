package dev.retrotv.crypt.owe;

import dev.retrotv.common.Log;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OWETest extends Log {
    protected final String PASSWORD = "The quick brown fox jumps over the lazy dog";

    protected void passwordEncryptAndMatchesTest(Password password) {
        String encryptedPassword = password.encode(PASSWORD);

        log.info(encryptedPassword);

        assertNotEquals(PASSWORD, encryptedPassword);
        assertTrue(password.matches(PASSWORD, encryptedPassword));
    }
}
