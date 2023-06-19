package dev.retrotv.crypt.owe.sha;

import dev.retrotv.enums.Algorithm;
import dev.retrotv.crypt.owe.OWETest;
import dev.retrotv.crypt.sha.SHA3256;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SHA3256Test extends OWETest {

    @Test
    @DisplayName("SHA3256 File hash 테스트")
    void fileHashTest() throws Exception {
        fileHashTest(Algorithm.SHA3256);
    }

    @Test
    @DisplayName("SHA3256 File hash matches 테스트")
    void fileHashMatchesTest() throws Exception {
        fileHashMatchesTest(new SHA3256(), Algorithm.SHA3256);
    }

    @Test
    @DisplayName("SHA3256 File and File matches 테스트")
    void fileMatchesTest() throws Exception {
        fileMatchesTest(new SHA3256());
    }

    @Test
    @DisplayName("SHA3256 password encode 테스트")
    void passwordEncrypt() {
        passwordEncryptAndMatchesTest(new SHA3256());
    }
}
