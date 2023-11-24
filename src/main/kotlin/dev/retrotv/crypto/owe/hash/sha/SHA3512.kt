package dev.retrotv.crypto.owe.hash.sha

import dev.retrotv.crypto.owe.hash.Hash
import dev.retrotv.data.enums.EncodeFormat
import dev.retrotv.data.utils.binaryEncode
import dev.retrotv.data.utils.binaryToHex
import dev.retrotv.enums.HashAlgorithm
import dev.retrotv.utils.encode

class SHA3512 : Hash() {
    override fun hash(data: ByteArray): String {
        return binaryToHex(encode(HashAlgorithm.SHA3512, data))
    }

    override fun hash(data: ByteArray, encodeFormat: EncodeFormat): String {
        return binaryEncode(encodeFormat, encode(HashAlgorithm.SHA3512, data))
    }
}
