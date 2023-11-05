package dev.retrotv.crypto.owe.hash.sha

import dev.retrotv.crypto.owe.hash.OWETest
import dev.retrotv.enums.HashAlgorithm
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class SHA3512Test : OWETest() {
    @Test
    @DisplayName("SHA3512 File hash 테스트")
    @Throws(Exception::class)
    fun fileHashTest() {
        fileHashTest(HashAlgorithm.SHA3512)
    }

    @Test
    @DisplayName("SHA3512 File hash matches 테스트")
    @Throws(Exception::class)
    fun fileHashMatchesTest() {
        fileHashMatchesTest(SHA3512(), HashAlgorithm.SHA3512)
    }

    @Test
    @DisplayName("SHA3512 File and File matches 테스트")
    @Throws(
        Exception::class
    )
    fun fileMatchesTest() {
        fileMatchesTest(SHA3512())
    }

    @Test
    @DisplayName("SHA3512 password encode 테스트")
    fun passwordEncrypt() {
        passwordEncryptAndMatchesTest(SHA3512())
    }
}
