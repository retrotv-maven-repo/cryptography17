package dev.retrotv.crypt.owe.sha;

import dev.retrotv.crypt.OneWayEncryption;
import dev.retrotv.crypt.owe.OWETest;
import dev.retrotv.crypt.sha.SHA3512;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

public class SHA3512Test extends OWETest {

    @Test
    @DisplayName("암호화 데이터 null 체크")
    void dataNullCheck() {
        OneWayEncryption owe = new SHA3512();
        parameterDataIsNullTest(owe);
    }

    @Test
    @DisplayName("암호화 문자열 null 체크")
    void textNullCheck() {
        OneWayEncryption owe = new SHA3512();
        parameterTextIsNullTest(owe);
    }

    @Test
    @DisplayName("base64 인코딩 테스트")
    void base64EncodeTest() {
        OneWayEncryption owe = new SHA3512();
        encryptedDataBase64EncodeTest(owe);
    }

    @RepeatedTest(100)
    @DisplayName("SHA3-512 알고리즘 암호화 테스트")
    void sha1EncryptTest(RepetitionInfo repetitionInfo) throws Exception {
        OneWayEncryption owe = new SHA3512();
        encryptWithoutSaltTest(owe, repetitionInfo);
    }

    @RepeatedTest(100)
    @DisplayName("SHA3-512 알고리즘 + 소금치기 암호화 테스트")
    void sha1EncryptWithSaltTest(RepetitionInfo repetitionInfo) throws Exception {
        OneWayEncryption owe = new SHA3512();
        encryptWithSaltTest(owe, repetitionInfo);
    }
}
