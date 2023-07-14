package dev.retrotv.crypt.owe.hash.sha;

import dev.retrotv.crypt.owe.hash.OWETest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static dev.retrotv.enums.HashAlgorithm.*;

public class SHA3384Test extends OWETest {

    @Test
    @DisplayName("SHA3384 File hash 테스트")
    void fileHashTest() throws Exception {
        fileHashTest(SHA3384);
    }

    @Test
    @DisplayName("SHA3384 File hash matches 테스트")
    void fileHashMatchesTest() throws Exception {
        fileHashMatchesTest(new SHA3384(), SHA3384);
    }

    @Test
    @DisplayName("SHA3384 File and File matches 테스트")
    void fileMatchesTest() throws Exception {
        fileMatchesTest(new SHA3384());
    }

    @Test
    @DisplayName("SHA3384 password encode 테스트")
    void passwordEncrypt() {
        passwordEncryptAndMatchesTest(new SHA3384());
    }
}