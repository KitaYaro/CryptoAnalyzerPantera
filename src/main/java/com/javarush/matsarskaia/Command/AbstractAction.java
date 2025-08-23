package com.javarush.matsarskaia.Command;

import com.javarush.matsarskaia.Alphabet;
import com.javarush.matsarskaia.FileHandler;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractAction implements Action {
    protected char[] alphabet;
    protected Map<Character, Integer> indexMap;

    public AbstractAction( char[] alphabet, Map<Character, Integer> indexMap){
        this.alphabet = alphabet;
        this.indexMap = indexMap;
    }

    public AbstractAction() {
        this.alphabet = Alphabet.getAlphabet();
        this.indexMap = new HashMap<>();
    }
    protected abstract int transformIndex(int oldIndex, int key);

    @Override
    public void execute(String inputFile, String outputFile, int key) {
        String sourceFile = FileHandler.readFile(inputFile);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < alphabet.length; i++) {
            indexMap.put(alphabet[i], i);
        }

        for (char symbol : sourceFile.toCharArray()) {
            if (indexMap.containsKey(symbol)) {
                int oldIndex = indexMap.get(symbol);
                int newIndex = transformIndex(oldIndex, key);
                result.append(alphabet[newIndex]);
            } else {
                result.append(symbol);
            }
        }
        FileHandler.writeFile(result.toString(), outputFile);
    }
}
