package dev.retrotv.crypto.owe.hash.sha

import dev.retrotv.crypto.owe.hash.Hash
import dev.retrotv.data.utils.binaryToHex
import dev.retrotv.enums.HashAlgorithm
import dev.retrotv.utils.encode

class SHA3384 : Hash() {
    override fun hash(data: ByteArray): String {
        return binaryToHex(encode(HashAlgorithm.SHA3384, data))
    }
}
