package com.javarush.matsarskaia.Command;

public interface Action {

    /* inputFile to read from file,
    outputFile to write to a file,
    key - shift key
     */
    void execute (String inputFile, String outputFile, int key);
}
