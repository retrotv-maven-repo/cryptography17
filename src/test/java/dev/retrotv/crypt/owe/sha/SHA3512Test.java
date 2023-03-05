package dev.retrotv.crypt.owe.sha;

import dev.retrotv.crypt.BaseEncode;
import dev.retrotv.crypt.OneWayEncryption;
import dev.retrotv.crypt.random.RandomValue;
import dev.retrotv.crypt.random.SecurityStrength;
import dev.retrotv.crypt.sha.SHA3512;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.logging.Logger;

public class SHA3512Test {
    private static final Logger log = Logger.getGlobal();

    @RepeatedTest(5)
    @DisplayName("SHA3-512 알고리즘 암호화 테스트")
    void md5EncryptTest() {
        String message = "The lazy dog jumps over the brown fox!";
        OneWayEncryption owe = new SHA3512();
        String salt = RandomValue.generate(SecurityStrength.HIGH, 20);

        String encryptedMessage = owe.encrypt(message, salt, BaseEncode.HEX);
        log.info("암호화 된 메시지: " + encryptedMessage);
    }
}
