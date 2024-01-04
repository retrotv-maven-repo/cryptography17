package dev.retrotv.crypto.owe.hash.sha

import dev.retrotv.crypto.owe.hash.HashAlgorithm
import dev.retrotv.data.enums.EncodeFormat
import dev.retrotv.data.utils.toHexString
import dev.retrotv.enums.Algorithm.Hash.SHA3384
import dev.retrotv.utils.digest
import dev.retrotv.utils.encode

/**
 * SHA3-384 알고리즘으로 암호화 하기 위한 [HashAlgorithm] 추상 클래스의 구현체 입니다.
 *
 * @author  yjj8353
 * @since   1.0.0
 */
class SHA3384 : HashAlgorithm() {
    override fun hash(data: ByteArray): String {
        return toHexString(digest(SHA3384, data))
    }

    override fun hash(data: ByteArray, encodeFormat: EncodeFormat): String {
        return encode(encodeFormat, digest(SHA3384, data))
    }
}
