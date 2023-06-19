package dev.retrotv.crypt.owe.sha;

import dev.retrotv.enums.Algorithm;
import dev.retrotv.crypt.owe.OWETest;
import dev.retrotv.crypt.sha.SHA3224;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SHA3224Test extends OWETest {

    @Test
    @DisplayName("SHA3224 File hash 테스트")
    void fileHashTest() throws Exception {
        fileHashTest(Algorithm.SHA3224);
    }

    @Test
    @DisplayName("SHA3224 File hash matches 테스트")
    void fileHashMatchesTest() throws Exception {
        fileHashMatchesTest(new SHA3224(), Algorithm.SHA3224);
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
