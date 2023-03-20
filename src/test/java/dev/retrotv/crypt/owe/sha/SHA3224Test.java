package dev.retrotv.crypt.owe.sha;

import dev.retrotv.crypt.owe.OWETest;
import dev.retrotv.crypt.sha.SHA3224;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SHA3224Test extends OWETest {

    @Test
    @DisplayName("SHA3224 password encode 테스트")
    void passwordEncrypt() {
        passwordEncryptAndMatchesTest(new SHA3224());
    }
}
