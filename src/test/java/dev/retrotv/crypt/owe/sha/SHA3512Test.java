package dev.retrotv.crypt.owe.sha;

import dev.retrotv.crypt.Algorithm;
import dev.retrotv.crypt.owe.OWETest;
import dev.retrotv.crypt.sha.SHA3512;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SHA3512Test extends OWETest {

    @Test
    @DisplayName("SHA3512 File hash 테스트")
    void fileHashTest() throws Exception {
        fileHashTest(Algorithm.SHA3512);
    }

    @Test
    @DisplayName("SHA3512 File hash matches 테스트")
    void fileHashMatchesTest() throws Exception {
        fileHashMatchesTest(new SHA3512(), Algorithm.SHA3512);
    }

    @Test
    @DisplayName("SHA3512 File and File matches 테스트")
    void fileMatchesTest() throws Exception {
        fileMatchesTest(new SHA3512());
    }

    @Test
    @DisplayName("SHA3512 password encode 테스트")
    void passwordEncrypt() {
        passwordEncryptAndMatchesTest(new SHA3512());
    }
}
