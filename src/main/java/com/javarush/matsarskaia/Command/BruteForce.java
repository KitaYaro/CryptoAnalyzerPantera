package com.javarush.matsarskaia.Command;

import com.javarush.matsarskaia.FileHandler;

import java.util.Map;

public class BruteForce extends AbstractAction {
    public BruteForce(char[] alphabet, Map<Character, Integer> integerMap) {
        super(alphabet, integerMap);
    }

    public BruteForce() {
        super();
    }

    @Override
    protected int transformIndex(int oldIndex, int key) {
        return (oldIndex - key + alphabet.length) % alphabet.length;
    }

    public void execute(String inputFile, String outputFile, int key) {
        try {

            String sourceFile = FileHandler.readFile(inputFile);
            for (int i = 0; i < alphabet.length; i++) {
                indexMap.put(alphabet[i], i);
            }
            for (int j = 0; j < alphabet.length; j++) {
                String result = transformText(sourceFile, j);

                if (result.contains("Ну что,")) {
                    FileHandler.writeFile(result, outputFile);
                    break;
                }
            }
        } catch (
                Exception e) {
            System.err.println("Warning BruteForce " + e.getMessage());
        }
    }
}