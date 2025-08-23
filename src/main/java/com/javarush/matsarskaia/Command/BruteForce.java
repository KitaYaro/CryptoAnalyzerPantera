package com.javarush.matsarskaia.Command;

import java.util.Map;

public class BruteForce extends AbstractAction{
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
}
