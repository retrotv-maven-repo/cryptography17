package dev.retrotv.crypto.owe.hash.sha;

import dev.retrotv.crypto.owe.hash.OWETest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static dev.retrotv.enums.HashAlgorithm.*;

public class SHA3224Test extends OWETest {

    @Test
    @DisplayName("SHA3224 File hash 테스트")
    void fileHashTest() throws Exception {
        fileHashTest(SHA3224);
    }

    @Test
    @DisplayName("SHA3224 File hash matches 테스트")
    void fileHashMatchesTest() throws Exception {
        fileHashMatchesTest(new SHA3224(), SHA3224);
    }

    @Test
    @DisplayName("SHA3224 File and File matches 테스트")
    void fileMatchesTest() throws Exception {
        fileMatchesTest(new SHA3224());
    }

    @Test
    @DisplayName("SHA3224 password encode 테스트")
    void passwordEncrypt() {
        passwordEncryptAndMatchesTest(new SHA3224());
    }
}