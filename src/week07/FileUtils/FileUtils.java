package week07.FileUtils;

/**
 * Created by georgipavlov on 12.01.16.
 */
import java.io.*;
import java.nio.file.Path;

public class FileUtils {

    private FileUtils() {

    }

    private static FileUtils mInstance;

    public static FileUtils getInstance() {
        if (mInstance == null) {
            mInstance = new FileUtils();
        }

        return mInstance;
    }

    public String readFrom(File file) throws IOException {

        BufferedReader buf = null;
        StringBuilder builder = new StringBuilder();

        try {
            buf = new BufferedReader(new FileReader(file));
            String line;

            while((line = buf.readLine()) != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
            }
        }
        finally {
            buf.close();
        }

        return builder.toString();
    }

    public String readFrom(Path path) throws IOException {
        return readFrom(path.toFile());
    }

    public void writeTo(String contents, File file) throws IOException {
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(file))) {
            buf.write(contents);
        }
    }

    public void writeTo(String contents, Path path) throws IOException {
        writeTo(contents, path.toFile());
    }
}