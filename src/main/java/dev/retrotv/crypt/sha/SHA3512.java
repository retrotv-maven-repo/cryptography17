package dev.retrotv.crypt.sha;

import dev.retrotv.crypt.Algorithm;
import dev.retrotv.crypt.OneWayEncryption;
import dev.retrotv.crypt.owe.Encode;

public class SHA3512 extends Encode implements OneWayEncryption {

    @Override
    public byte[] encrypt(byte[] data) {
        return encode(Algorithm.SHA3512, data);
    }
}
