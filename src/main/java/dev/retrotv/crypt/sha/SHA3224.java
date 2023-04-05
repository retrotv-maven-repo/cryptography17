package dev.retrotv.crypt.sha;

import dev.retrotv.crypt.Algorithm;
import dev.retrotv.crypt.Encode;
import dev.retrotv.crypt.owe.Checksum;
import dev.retrotv.crypt.owe.Encrypt;
import dev.retrotv.crypt.owe.PasswordWithSalt;

import java.nio.charset.StandardCharsets;

public class SHA3224 extends Encrypt implements Checksum, PasswordWithSalt {

    @Override
    public String encode(byte[] data) {
        return Encode.binaryToHex(encode(Algorithm.SHA3224, data));
    }

    @Override
    public String encode(CharSequence rawPassword) {
        String password = String.valueOf(rawPassword);
        return encode(password.getBytes(StandardCharsets.UTF_8));
    }
}
