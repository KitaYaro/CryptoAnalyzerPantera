package com.javarush.matsarskaia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    public static final String INPUT_FILE = "E:\\Java MyProject\\CryptoAnalyzerPantera\\text\\text.txt";
    public static final String ENCRYPTED_FILE = "E:\\Java MyProject\\CryptoAnalyzerPantera\\text\\encrypted.txt";
    public static final String DECRYPTED_FILE = "E:\\Java MyProject\\CryptoAnalyzerPantera\\text\\decrypted.txt";

    //метод для чтения из файла
    public static String readFile(String filePath) {
        Path path = Paths.get(filePath);
        StringBuilder builder = new StringBuilder();
        String line;
        try (BufferedReader buffer = Files.newBufferedReader(path)){
            while ((line = buffer.readLine()) != null){
                 builder.append(line);
                 builder.append("\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении из файла " + e.getMessage());
        }
        return builder.toString();
    }

    public static void writeFile(String content, String filePath){
        Path path = Paths.get(filePath);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

            writer.write(content);
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл " + e.getMessage());
        }
    }
}
