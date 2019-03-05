package org.pitrecki.utils;

import com.google.common.io.Files;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Document;

import java.io.IOException;

import static com.google.common.base.Charsets.UTF_8;
import static lombok.AccessLevel.PRIVATE;
import static org.springframework.util.ResourceUtils.getFile;

@NoArgsConstructor(access = PRIVATE)
public class TestUtils {

    private static final String EMPTY_BASE_URI = "";

    public static String loadFile(String path) throws IOException {
        return Files.toString(getFile(path), UTF_8);
    }

    public static Document loadEmtpyDocument() {
        return new Document(EMPTY_BASE_URI);
    }
}


