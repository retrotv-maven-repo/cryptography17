package dev.retrotv.crypt.owe;

import dev.retrotv.common.Log;
import dev.retrotv.crypt.Algorithm;
import dev.retrotv.crypt.sha.*;
import org.json.JSONObject;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class OWETest extends Log {
    protected final String PASSWORD = "The quick brown fox jumps over the lazy dog";
    protected  final URL CHECKSUM = this.getClass().getClassLoader().getResource("checksum");
    protected final URL RESOURCE = this.getClass().getClassLoader().getResource("checksum_test_file.txt");
    protected final URL RESOURCE2 = this.getClass().getClassLoader().getResource("checksum_test_file2.txt");

    protected void fileHashTest(Algorithm algorithm) throws IOException {
        File file;
        byte[] fileData;

        try {
            file = new File(Objects.requireNonNull(RESOURCE).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try (DataInputStream dis = new DataInputStream(Files.newInputStream(file.toPath()))) {
            fileData = new byte[(int) file.length()];
            dis.readFully(fileData);
        } catch (IOException e) {
            throw new IOException("파일을 읽어들이는 과정에서 예상치 못한 오류가 발생했습니다.");
        }

        assertEquals(getHash(algorithm), hash(algorithm, fileData));
    }

    protected void fileHashMatchesTest(Checksum checksum, Algorithm algorithm) throws IOException {
        File file;
        byte[] fileData;

        try {
            file = new File(Objects.requireNonNull(RESOURCE).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try (DataInputStream dis = new DataInputStream(Files.newInputStream(file.toPath()))) {
            fileData = new byte[(int) file.length()];
            dis.readFully(fileData);
        } catch (IOException e) {
            throw new IOException("파일을 읽어들이는 과정에서 예상치 못한 오류가 발생했습니다.");
        }

        assertTrue(checksum.matches(fileData, getHash(algorithm)));
    }

    protected void fileMatchesTest(Checksum checksum) throws IOException {
        if (RESOURCE != null && RESOURCE2 != null) {
            assertTrue(checksum.matches(new File(RESOURCE.getFile()), new File(RESOURCE2.getFile())));
        } else {
            fail();
        }
    }

    protected void passwordEncryptAndMatchesTest(Password password) {
        String encryptedPassword = password.encode(PASSWORD);

        log.info(encryptedPassword);

        assertNotEquals(PASSWORD, encryptedPassword);
        assertTrue(password.matches(PASSWORD, encryptedPassword));
    }

    private String hash(Algorithm algorithm, byte[] fileData) {
        switch (algorithm) {
            case SHA3224 -> {
                Checksum checksum = new SHA3224();
                return checksum.encode(fileData);
            }

            case SHA3256 -> {
                Checksum checksum = new SHA3256();
                return checksum.encode(fileData);
            }

            case SHA3384 -> {
                Checksum checksum = new SHA3384();
                return checksum.encode(fileData);
            }

            case SHA3512 -> {
                Checksum checksum = new SHA3512();
                return checksum.encode(fileData);
            }

            default -> {
                return null;
            }
        }
    }

    private String getHash(Algorithm algorithm) throws IOException {
        JSONObject jsonObject = new JSONObject(readJson());
        JSONObject file1 = jsonObject.getJSONObject("checksum_test_file");

        return switch (algorithm) {
            case SHA3224 -> file1.getString(Algorithm.SHA3224.label());
            case SHA3256 -> file1.getString(Algorithm.SHA3256.label());
            case SHA3384 -> file1.getString(Algorithm.SHA3384.label());
            case SHA3512 -> file1.getString(Algorithm.SHA3512.label());
            default -> null;
        };
    }

    private String readJson() throws IOException {
        if (CHECKSUM == null) {
            throw new IOException();
        }

        String json;

        try(BufferedReader reader = new BufferedReader(new FileReader(CHECKSUM.getFile()))) {
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = reader.readLine();
            }
            json = sb.toString();
        }

        log.info(json);

        return json;
    }
}
