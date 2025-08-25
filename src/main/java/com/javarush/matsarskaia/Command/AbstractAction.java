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
        protected String transformText(String text, int key){
            StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            char loverCh = Character.toLowerCase(ch);
            if (indexMap.containsKey(loverCh)) {
                int oldIndex = indexMap.get(loverCh);
                int newIndex = transformIndex(oldIndex, key);
                result.append(alphabet[newIndex]);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    @Override
    public void execute(String inputFile, String outputFile, int key) {
        for (int i = 0; i < alphabet.length; i++) {
            indexMap.put(alphabet[i], i);
        }
        try {
            String sourceFile = FileHandler.readFile(inputFile);
            String result = transformText(sourceFile, key);

            FileHandler.writeFile(result, outputFile);
        } catch (Exception e) {
            System.err.println("Warning AbstractionAction " + e.getMessage());
        }
    }
}
