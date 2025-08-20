package com.javarush.matsarskaia;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    //метод для чтения из файла
    public static String readFile(String filePath) {
        Path path = Paths.get(filePath);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader buffer = Files.newBufferedReader(path)){
            while (buffer.ready()){
                 String line = buffer.readLine();
                 builder.append(line);
                 builder.append("\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении из файла" + e.getMessage());
        }
        return builder.toString();
    }

    public void writeFile(String content, String filePath){

    }
}
