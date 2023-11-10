package dev.retrotv.crypto.owe.hash.sha

import dev.retrotv.crypto.owe.hash.Hash
import dev.retrotv.data.utils.binaryToHex
import dev.retrotv.enums.HashAlgorithm
import dev.retrotv.utils.MessageDigestEncodeUtil

class SHA3512 : Hash() {
    override fun hash(data: ByteArray): String {
        return binaryToHex(MessageDigestEncodeUtil.encode(HashAlgorithm.SHA3512, data))
    }
}
