package app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    private final static String BASE_PATH = "files/";
// add fileName parameter to writeFile()
    public String writeFile(String fileContent,String fileName) {
        try (FileWriter fw = new FileWriter(BASE_PATH +fileName+ ".txt")) {
            fw.write(fileContent);  // використання методу write() для запису в файл
            return "Success.";
        } catch (Exception e) {
            return "Error: " + e.getMessage(); // повернення повідомлення про помилку
        }
    }

    public String readFile(String path) {
        try (FileReader reader = new FileReader(path)) {
            int sym;
            StringBuilder stringBuilder = new StringBuilder(); // створення StringBuilder
            while ((sym = reader.read()) != -1) {
                stringBuilder.append((char) sym);
            }
            return stringBuilder.toString(); // повернення зчитаного рядка
        } catch (IOException ex) {
            return "Error: " + ex.getMessage(); // повернення повідомлення про помилку
        }
    }
}