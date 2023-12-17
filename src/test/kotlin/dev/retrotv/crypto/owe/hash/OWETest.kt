package dev.retrotv.crypto.owe.hash

import dev.retrotv.common.Log
import dev.retrotv.crypto.owe.hash.sha.*
import dev.retrotv.enums.Algorithm
import org.json.JSONObject
import org.junit.jupiter.api.Assertions
import org.springframework.security.crypto.password.PasswordEncoder
import java.io.*
import java.net.URISyntaxException
import java.net.URL
import java.nio.file.Files
import java.util.*

open class OWETest : Log() {
    protected val PASSWORD = "The quick brown fox jumps over the lazy dog"
    protected val CHECKSUM = this.javaClass.getClassLoader().getResource("checksum")
    protected val RESOURCE = this.javaClass.getClassLoader().getResource("checksum_test_file.txt")
    protected val RESOURCE2 = this.javaClass.getClassLoader().getResource("checksum_test_file2.txt")

    @Throws(IOException::class)
    protected fun fileHashTest(algorithm: Algorithm.Hash) {
        var fileData: ByteArray
        val file: File = try {
            File(Objects.requireNonNull<URL?>(RESOURCE).toURI())
        } catch (e: URISyntaxException) {
            throw RuntimeException(e)
        }
        try {
            DataInputStream(Files.newInputStream(file.toPath())).use { dis ->
                fileData = ByteArray(file.length().toInt())
                dis.readFully(fileData)
            }
        } catch (e: IOException) {
            throw IOException("파일을 읽어들이는 과정에서 예상치 못한 오류가 발생했습니다.")
        }
        Assertions.assertEquals(getHash(algorithm), hash(algorithm, fileData))
    }

    @Throws(IOException::class)
    protected fun fileHashMatchesTest(checksum: Hash, algorithm: Algorithm.Hash) {
        var fileData: ByteArray
        val file: File = try {
            File(Objects.requireNonNull<URL?>(RESOURCE).toURI())
        } catch (e: URISyntaxException) {
            throw RuntimeException(e)
        }
        try {
            DataInputStream(Files.newInputStream(file.toPath())).use { dis ->
                fileData = ByteArray(file.length().toInt())
                dis.readFully(fileData)
            }
        } catch (e: IOException) {
            throw IOException("파일을 읽어들이는 과정에서 예상치 못한 오류가 발생했습니다.")
        }
        Assertions.assertTrue(checksum.matches(fileData, getHash(algorithm)))
    }

    @Throws(IOException::class)
    protected fun fileMatchesTest(checksum: FileHash) {
        if (RESOURCE != null && RESOURCE2 != null) {
            Assertions.assertTrue(checksum.matches(File(RESOURCE.file), File(RESOURCE2.file)))
        } else {
            Assertions.fail<Any>()
        }
    }

    protected fun passwordEncryptAndMatchesTest(password: PasswordEncoder) {
        val encryptedPassword: String = password.encode(PASSWORD)
        log.info(encryptedPassword)
        Assertions.assertNotEquals(PASSWORD, encryptedPassword)
        Assertions.assertTrue(password.matches(PASSWORD, encryptedPassword))
    }

    private fun hash(algorithm: Algorithm.Hash, fileData: ByteArray): String? {
        return when (algorithm) {
            Algorithm.Hash.SHA3224 -> {
                val checksum: Hash = SHA3224()
                checksum.hash(fileData)
            }

            Algorithm.Hash.SHA3256 -> {
                val checksum: Hash = SHA3256()
                checksum.hash(fileData)
            }

            Algorithm.Hash.SHA3384 -> {
                val checksum: Hash = SHA3384()
                checksum.hash(fileData)
            }

            Algorithm.Hash.SHA3512 -> {
                val checksum: Hash = SHA3512()
                checksum.hash(fileData)
            }

            else -> {
                null
            }
        }
    }

    @Throws(IOException::class)
    private fun getHash(algorithm: Algorithm.Hash): String {
        val jsonObject = JSONObject(readJson())
        val file1 = jsonObject.getJSONObject("checksum_test_file")
        return when (algorithm) {
            Algorithm.Hash.SHA3224 -> file1.getString(Algorithm.Hash.SHA3224.label())
            Algorithm.Hash.SHA3256 -> file1.getString(Algorithm.Hash.SHA3256.label())
            Algorithm.Hash.SHA3384 -> file1.getString(Algorithm.Hash.SHA3384.label())
            Algorithm.Hash.SHA3512 -> file1.getString(Algorithm.Hash.SHA3512.label())
            else -> ""
        }
    }

    @Throws(IOException::class)
    private fun readJson(): String {
        if (CHECKSUM == null) {
            throw IOException()
        }
        var json: String
        BufferedReader(FileReader(CHECKSUM.file)).use { reader ->
            val sb = StringBuilder()
            var line = reader.readLine()
            while (line != null) {
                sb.append(line)
                sb.append("\n")
                line = reader.readLine()
            }
            json = sb.toString()
        }
        log.info(json)
        return json
    }
}
