package dev.retrotv.crypt.sha;

import dev.retrotv.crypt.Algorithm;
import dev.retrotv.crypt.OneWayEncryption;
import dev.retrotv.crypt.owe.Encrypt;

public class SHA3224 extends Encrypt implements OneWayEncryption {

    @Override
    public byte[] encrypt(byte[] data) {
        return encrypt(Algorithm.SHA3224, data);
    }
}
