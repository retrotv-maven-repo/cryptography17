package dev.retrotv.crypto.owe.hash.sha

import dev.retrotv.crypto.owe.hash.HashAlgorithm
import dev.retrotv.data.enums.EncodeFormat
import dev.retrotv.data.utils.binaryEncode
import dev.retrotv.data.utils.binaryToHex
import dev.retrotv.enums.Algorithm.Hash.SHA3256
import dev.retrotv.utils.encode

class SHA3256 : HashAlgorithm() {
    override fun hash(data: ByteArray): String {
        return binaryToHex(encode(SHA3256, data))
    }

    override fun hash(data: ByteArray, encodeFormat: EncodeFormat): String {
        return binaryEncode(encodeFormat, encode(SHA3256, data))
    }
}
