package dev.retrotv.crypt.sha;

import dev.retrotv.crypt.Algorithm;
import dev.retrotv.crypt.exception.CryptFailException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class SHA3 {
    protected byte[] encode(Algorithm algorithm, byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm.label());
            md.update(data);

            return md.digest();
        } catch (NoSuchAlgorithmException ignored) { }

        throw new CryptFailException("암호화가 정상적으로 진행되지 않았습니다.");
    }
}
