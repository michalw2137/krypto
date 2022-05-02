package szyfr;

import java.io.*;

public class Files {

    public static byte[] readIntoBytes(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fl = new FileInputStream(file);
        byte[] arr = new byte[(int)file.length()];
        fl.read(arr);
        fl.close();
        return arr;
    }

    public static void writeFromBytes(String filePath, byte[] arr) throws IOException {
        File file = new File(filePath);
        OutputStream os = new FileOutputStream(file);
        os.write(arr);
        os.close();
    }
}
