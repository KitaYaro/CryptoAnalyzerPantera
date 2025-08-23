package com.javarush.matsarskaia.Command;

import java.util.Map;

public class Decode extends AbstractAction{
    public Decode(char[] alphabet, Map<Character, Integer> integerMap) {
        super(alphabet, integerMap);
    }

    public Decode() {
        super();
    }

    @Override
    protected int transformIndex(int oldIndex, int key) {
        return (oldIndex - key + alphabet.length) % alphabet.length;
    }
}
