package dev.retrotv.crypt.owe.hash.sha;

import dev.retrotv.crypto.owe.hash.Hash;
import dev.retrotv.utils.EncodeUtil;
import dev.retrotv.utils.MessageDigestEncodeUtil;
import lombok.NonNull;

import static dev.retrotv.enums.HashAlgorithm.SHA3224;

public class SHA3224 extends Hash {

    @Override
    public String hash(@NonNull byte[] data) {
        return EncodeUtil.binaryToHex(MessageDigestEncodeUtil.encode(SHA3224, data));
    }
}
