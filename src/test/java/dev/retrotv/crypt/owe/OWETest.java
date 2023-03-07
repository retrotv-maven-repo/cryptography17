package dev.retrotv.crypt.owe;

import dev.retrotv.common.Log;
import dev.retrotv.crypt.Encode;
import dev.retrotv.crypt.EncodeFormat;
import dev.retrotv.crypt.OneWayEncryption;
import dev.retrotv.crypt.exception.CryptFailException;
import dev.retrotv.crypt.random.RandomValue;
import dev.retrotv.crypt.random.SecurityStrength;
import org.junit.jupiter.api.RepetitionInfo;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class OWETest extends Log {
    protected static final Set<String> encryptedData = new HashSet<>();

    protected void parameterDataIsNullTest(OneWayEncryption owe) {
        Throwable exception = assertThrows(CryptFailException.class, () -> owe.encrypt((byte[]) null));

        log.info("예외 메시지: " + exception.getMessage());
        assertEquals("암호화 할 문자열 및 데이터는 null 일 수 없습니다.", exception.getMessage());
    }

    protected void parameterTextIsNullTest(OneWayEncryption owe) {
        Throwable exception = assertThrows(CryptFailException.class, () -> owe.encrypt((String) null, EncodeFormat.HEX));

        log.info("예외 메시지: " + exception.getMessage());
        assertEquals("암호화 할 문자열 및 데이터는 null 일 수 없습니다.", exception.getMessage());
    }

    protected void encryptedDataBase64EncodeTest(OneWayEncryption owe) {
        String message = "The lazy dog jumps over the brown fox!";
        String encryptedMessage = owe.encrypt(message, EncodeFormat.BASE64);

        log.info("암호화 된 메시지: " + encryptedMessage);

        assertTrue(owe.matches(message, EncodeFormat.BASE64, encryptedMessage));
    }

    protected void encryptWithoutSaltTest(OneWayEncryption owe, RepetitionInfo repetitionInfo) throws Exception {
        log.info("암호화 알고리즘: " + owe.getClass().getSimpleName());

        String message = "The lazy dog jumps over the brown fox!";
        String encryptedMessage = owe.encrypt(message, EncodeFormat.HEX);

        assertTrue(owe.matches(message, encryptedMessage));
        assertTrue(owe.matches(message, EncodeFormat.HEX, encryptedMessage));
        assertTrue(checkBitLength(owe.getClass().getSimpleName(), (Encode.hexToBinary(encryptedMessage).length * 8)));

        encryptedData.add(encryptedMessage);
        if(repetitionInfo.getCurrentRepetition() == repetitionInfo.getTotalRepetitions()) {
            log.info("마지막 테스트");
            log.info("총 테스트 횟수: " + repetitionInfo.getCurrentRepetition());
            log.info("암호화 된 데이터 개수 : " + encryptedData.size());
            if(encryptedData.size() != 1) { fail(); }

            encryptedData.clear();
        }
    }

    protected void encryptWithSaltTest(OneWayEncryption owe, RepetitionInfo repetitionInfo) throws Exception {
        log.info("암호화 알고리즘: " + owe.getClass().getSimpleName());

        String message = "The lazy dog jumps over the brown fox!";
        String salt = RandomValue.generate(SecurityStrength.HIGH, 20);
        String encryptedMessage = owe.encrypt(message, salt, EncodeFormat.HEX);

        log.info("암호화 된 메시지: " + encryptedMessage);
        log.info("암호화 된 메시지 bit 길이: " + (Encode.hexToBinary(encryptedMessage).length * 8));

        assertTrue(owe.matches(message, salt, encryptedMessage));
        assertTrue(owe.matches(message, salt, EncodeFormat.HEX, encryptedMessage));
        assertTrue(checkBitLength(owe.getClass().getSimpleName(), (Encode.hexToBinary(encryptedMessage).length * 8)));

        encryptedData.add(encryptedMessage);
        if(repetitionInfo.getCurrentRepetition() == repetitionInfo.getTotalRepetitions()) {
            log.info("마지막 테스트");
            log.info("총 테스트 횟수: " + repetitionInfo.getCurrentRepetition());
            log.info("암호화 된 데이터 개수 : " + encryptedData.size());
            if(repetitionInfo.getTotalRepetitions() != encryptedData.size()) { fail(); }

            encryptedData.clear();
        }
    }

    private boolean checkBitLength(String algorithm, int length) {
        return switch (algorithm) {
            case "CRC32" -> length == 32;
            case "MD2", "MD5" -> length == 128;
            case "SHA1" -> length == 160;
            case "SHA224", "SHA512224", "SHA3224" -> length == 224;
            case "SHA256", "SHA512256", "SHA3256" -> length == 256;
            case "SHA384", "SHA3384" -> length == 384;
            case "SHA512", "SHA3512" -> length == 512;
            default -> false;
        };

    }
}
