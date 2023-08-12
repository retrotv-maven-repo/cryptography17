package dev.retrotv.crypt.owe.hash.sha;

import dev.retrotv.crypto.owe.hash.Hash;
import dev.retrotv.utils.EncodeUtil;
import dev.retrotv.utils.MessageDigestEncodeUtil;
import lombok.NonNull;

import static dev.retrotv.enums.HashAlgorithm.SHA3512;

public class SHA3512 extends Hash {

    @Override
    public String hash(@NonNull byte[] data) {
        return EncodeUtil.binaryToHex(MessageDigestEncodeUtil.encode(SHA3512, data));
    }
}
