package dev.retrotv.crypt.sha;

import dev.retrotv.crypt.OneWayEncryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA3256 implements OneWayEncryption {

    @Override
    public byte[] encrypt(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA3-256");
            md.update(data);
            return md.digest();
        } catch (NoSuchAlgorithmException ignored) { }

        return null;
    }
}
