package dev.retrotv.crypt.owe.sha;

import dev.retrotv.crypt.OneWayEncryption;
import dev.retrotv.crypt.owe.OWETest;
import dev.retrotv.crypt.sha.SHA3384;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

public class SHA3384Test extends OWETest {

    @Test
    @DisplayName("암호화 데이터 null 체크")
    void dataNullCheck() {
        OneWayEncryption owe = new SHA3384();
        parameterDataIsNullTest(owe);
    }

    @Test
    @DisplayName("암호화 문자열 null 체크")
    void textNullCheck() {
        OneWayEncryption owe = new SHA3384();
        parameterTextIsNullTest(owe);
    }

    @Test
    @DisplayName("base64 인코딩 테스트")
    void base64EncodeTest() {
        OneWayEncryption owe = new SHA3384();
        encryptedDataBase64EncodeTest(owe);
    }

    @RepeatedTest(100)
    @DisplayName("SHA3-384 알고리즘 암호화 테스트")
    void sha1EncryptTest(RepetitionInfo repetitionInfo) throws Exception {
        OneWayEncryption owe = new SHA3384();
        encryptWithoutSaltTest(owe, repetitionInfo);
    }

    @RepeatedTest(100)
    @DisplayName("SHA3-384 알고리즘 + 소금치기 암호화 테스트")
    void sha1EncryptWithSaltTest(RepetitionInfo repetitionInfo) throws Exception {
        OneWayEncryption owe = new SHA3384();
        encryptWithSaltTest(owe, repetitionInfo);
    }
}
