package dev.retrotv.crypt.sha;

import dev.retrotv.crypt.Algorithm;
import dev.retrotv.crypt.Encode;
import dev.retrotv.crypt.owe.Checksum;
import dev.retrotv.crypt.owe.Encrypt;
import dev.retrotv.crypt.owe.PasswordWithSalt;
import dev.retrotv.util.CommonMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;

public class SHA3384 extends Encrypt implements Checksum, PasswordWithSalt {
    private static final Logger logger = LogManager.getLogger();
    private static final CommonMessage commonMessage = new CommonMessage();

    @Override
    public String encode(byte[] data) {
        if (data == null) {
            logger.error(commonMessage.getMessage("error.parameter.null", "data"));
            throw new NullPointerException(commonMessage.getMessage("exception.nullPointer", "data"));
        }

        return Encode.binaryToHex(encode(Algorithm.SHA3384, data));
    }

    @Override
    public String encode(CharSequence rawPassword) {
        if (rawPassword == null) {
            logger.error(commonMessage.getMessage("error.parameter.null", "rawPassword"));
            throw new NullPointerException(commonMessage.getMessage("exception.nullPointer", "rawPassword"));
        }

        String password = String.valueOf(rawPassword);
        return encode(password.getBytes(StandardCharsets.UTF_8));
    }
}
