package szyfr;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class Files {

    public static byte[] readFileIntoBytes(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fl = new FileInputStream(file);
        byte[] arr = new byte[(int)file.length()];
        fl.read(arr);
        fl.close();
        return arr;
    }

    public static void writeFileFromBytes(String filePath, byte[] arr) throws IOException {
        File file = new File(filePath);
        OutputStream os = new FileOutputStream(file);
        os.write(arr);
        os.close();
    }

    public static byte[] stringToBytes(String string) {
        return string.getBytes(StandardCharsets.UTF_8);
    }


    public static void writeStringFromBytes(String filePath, byte[] arr) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j<arr.length; j++) {
            sb.append(String.format("%8s", Integer.toBinaryString(arr[j] & 0xFF)).replace(' ', '0'));
        }
        File file = new File(filePath);
        OutputStream os = new FileOutputStream(file);
        os.write(sb.toString().getBytes(StandardCharsets.UTF_8));
        os.close();
    }

    public static byte[] readBytesfromString(String filePath) throws FileNotFoundException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader buffer = new BufferedReader(
                new FileReader(filePath))) {

            String str;
            while ((str = buffer.readLine()) != null) {

                builder.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int splitSize = 8;
        String binaryString = builder.toString();
        if(binaryString.length() % splitSize == 0){
            int index = 0;
            int position = 0;

            byte[] resultByteArray = new byte[binaryString.length()/splitSize];
            StringBuilder text = new StringBuilder(binaryString);

            while (index < text.length()) {
                String binaryStringChunk = text.substring(index, Math.min(index + splitSize, text.length()));
                Integer byteAsInt = Integer.parseInt(binaryStringChunk, 2);
                resultByteArray[position] = byteAsInt.byteValue();
                index += splitSize;
                position ++;
            }
            return resultByteArray;
        }
        else{
            System.out.println("Cannot convert binary string to byte[], because of the input length. '" +binaryString+"' % 8 != 0");
            return null;
        }
    }
}
