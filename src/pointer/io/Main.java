package pointer.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static final String PATH = "C:\\Users\\vital\\Desktop\\pointer.java\\notes.txt";

    public static void main(String[] args) throws IOException {
//        writeDataToFile("Lorem", PATH);
        writeDataToFile("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.", PATH);
        System.out.println(readDataFromFile(PATH));
    }

    private static void writeDataToFile(String data, String path) throws IOException {
        File file = new File(path);
        file.createNewFile();
        try (FileOutputStream fos = new FileOutputStream(file, false)) {

            byte[] dataAsBytes = data.getBytes();

            fos.write(dataAsBytes, 0, dataAsBytes.length);

            System.out.println("The file has been written.");
        } catch (IOException ex) {
            System.out.println("AAA");
        }
    }

    private static String readDataFromFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        byte[] buffer = new byte[20];

        try (FileInputStream fis = new FileInputStream(path)) {
            int available = fis.available();
            System.out.printf("File size: %d bytes\n", available);
            int i = buffer.length;

            while (i != -1) {
                stringBuilder.append(new String(buffer));
                i = fis.read(buffer, 0, buffer.length);
            }

        } catch (IOException ex) {
            System.out.println("AAA");
        }

        return stringBuilder.toString();
    }
}
