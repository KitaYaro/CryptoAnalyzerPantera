package com.javarush.matsarskaia.Command;

import java.util.Map;

public class Encode extends AbstractAction {

    public Encode(char[] alphabet, Map<Character, Integer> integerMap) {
        super(alphabet, integerMap);
    }

    public Encode() {
        super();
    }

    @Override
    protected int transformIndex(int oldIndex, int key) {
        return (oldIndex + key) % alphabet.length;
    }
}