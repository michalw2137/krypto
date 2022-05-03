package szyfr;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class Files {

    public static byte[] readFileIntoBytesAddExtension(String filePath) throws IOException {
        File file = new File(filePath);
        String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
        FileInputStream fl = new FileInputStream(file);
        byte[] arr = new byte[(int)file.length() + extension.length() + 1];
        fl.read(arr);
        int j = extension.length()-1;
        for(int i = arr.length-2; i>arr.length - 2 -extension.length(); i--){
            arr[i]=(byte)extension.charAt(j);
            j--;
        }
        arr[arr.length-1]=(byte)extension.length();
        fl.close();
        return arr;
    }
    public static byte[] readFileIntoBytes(String filePath) throws IOException {
        File file = new File(filePath);;
        FileInputStream fl = new FileInputStream(file);
        byte[] arr = new byte[(int)file.length() +  1];
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
    public static String createFullPath(String filePath, byte[] arr) throws IOException {
        int extensionSize = arr[arr.length -1];
        byte[] temp = new byte[extensionSize];
        int j = extensionSize-1;
        for(int i = arr.length-2; i>arr.length - 2 - extensionSize; i--){
            temp[j]=(byte)arr[i];
            j--;
        }
        String s = new String(temp, StandardCharsets.UTF_8);
        System.out.println(s);
        return new StringBuilder().append(filePath).append(".").append(s).toString();
    }
    public static void writeFileFromBytesWithExtension(String filePath, byte[] arr) throws IOException {
        File file = new File(createFullPath(filePath, arr));
        OutputStream os = new FileOutputStream(file);
        for(int i = 0; i>arr.length - 1 - arr[arr.length - 1]; i++){
            os.write(arr[i]);
        }

        os.close();
    }

    public static byte[] stringToBytes(String string) {
        return string.getBytes(StandardCharsets.UTF_8);
    }

    public static String convertBytesToString(byte[] arr) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j<arr.length; j++) {
            sb.append(String.format("%8s", Integer.toBinaryString(arr[j] & 0xFF)).replace(' ', '0'));
        }
        return sb.toString();
    }

    public static void writeStringFromBytes(String filePath, String arr) throws IOException {
        File file = new File(filePath);
        OutputStream os = new FileOutputStream(file);
        os.write(arr.getBytes(StandardCharsets.UTF_8));
        os.close();
    }

    public static String getStringFromFile(String filePath){
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
        return builder.toString();
    }
    public static byte[] readBytesfromString(String binaryString) throws FileNotFoundException {

        int splitSize = 8;

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
