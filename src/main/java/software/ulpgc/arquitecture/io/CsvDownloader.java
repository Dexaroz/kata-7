package software.ulpgc.arquitecture.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CsvDownloader {
    public static void downloadCsv(String imageURL, String route) throws IOException {
        URL url = new URL(imageURL);
        InputStream inputStream = url.openStream();
        Path path = Paths.get(route);
        Files.copy(inputStream,path, StandardCopyOption.REPLACE_EXISTING);
        inputStream.close();
    }
}
