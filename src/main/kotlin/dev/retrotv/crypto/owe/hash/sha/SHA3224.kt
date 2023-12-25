package dev.retrotv.crypto.owe.hash.sha

import dev.retrotv.crypto.owe.hash.HashAlgorithm
import dev.retrotv.data.enums.EncodeFormat
import dev.retrotv.data.utils.binaryEncode
import dev.retrotv.data.utils.binaryToHex
import dev.retrotv.enums.Algorithm.Hash.SHA3224
import dev.retrotv.utils.encode

/**
 * SHA3-224 알고리즘으로 암호화 하기 위한 [HashAlgorithm] 추상 클래스의 구현체 입니다.
 *
 * @author  yjj8353
 * @since   1.0.0
 */
class SHA3224 : HashAlgorithm() {
    override fun hash(data: ByteArray): String {
        return binaryToHex(encode(SHA3224, data))
    }

    override fun hash(data: ByteArray, encodeFormat: EncodeFormat): String {
        return binaryEncode(encodeFormat, encode(SHA3224, data))
    }
}
