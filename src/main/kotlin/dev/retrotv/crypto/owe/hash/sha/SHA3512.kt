package dev.retrotv.crypto.owe.hash.sha

import dev.retrotv.crypto.owe.hash.HashAlgorithm
import dev.retrotv.data.enums.EncodeFormat
import dev.retrotv.data.utils.binaryEncode
import dev.retrotv.data.utils.binaryToHex
import dev.retrotv.enums.HashAlgorithm.SHA3512
import dev.retrotv.utils.encode

class SHA3512 : HashAlgorithm() {
    override fun hash(data: ByteArray): String {
        return binaryToHex(encode(SHA3512, data))
    }

    override fun hash(data: ByteArray, encodeFormat: EncodeFormat): String {
        return binaryEncode(encodeFormat, encode(SHA3512, data))
    }
}
