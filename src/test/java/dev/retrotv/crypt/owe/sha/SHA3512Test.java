package dev.retrotv.crypt.owe.sha;

import dev.retrotv.crypt.owe.OWETest;
import dev.retrotv.crypt.sha.SHA3512;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SHA3512Test extends OWETest {

    @Test
    @DisplayName("SHA3512 password encode 테스트")
    void passwordEncrypt() {
        passwordEncryptAndMatchesTest(new SHA3512());
    }
}
