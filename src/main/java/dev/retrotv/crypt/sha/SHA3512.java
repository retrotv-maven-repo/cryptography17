package dev.retrotv.crypt.sha;

import dev.retrotv.crypt.owe.MessageDigestEncode;
import dev.retrotv.enums.Algorithm;
import dev.retrotv.utils.EncodeUtil;
import lombok.NonNull;

public class SHA3512 extends MessageDigestEncode {

    @Override
    public String hash(@NonNull byte[] data) {
        return EncodeUtil.binaryToHex(encode(Algorithm.SHA3512, data));
    }
}
