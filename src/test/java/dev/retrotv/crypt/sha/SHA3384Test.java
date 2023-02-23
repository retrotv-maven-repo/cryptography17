package dev.retrotv.crypt.sha;

import dev.retrotv.crypt.Encode;
import dev.retrotv.crypt.OneWayEncryption;
import dev.retrotv.crypt.owe.Salt;
import dev.retrotv.crypt.random.SecurityStrength;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.logging.Logger;

public class SHA3384Test {
    private static final Logger log = Logger.getGlobal();

    @RepeatedTest(5)
    @DisplayName("SHA3-384 알고리즘 암호화 테스트")
    void md5EncryptTest() {
        String message = "The lazy dog jumps over the brown fox!";
        OneWayEncryption owe = new SHA3256();
        String salt = Salt.generate(SecurityStrength.HIGH, 20);

        String encryptedMessage = owe.encrypt(message, salt, Encode.HEX);
        log.info("암호화 된 메시지: " + encryptedMessage);
    }
}
