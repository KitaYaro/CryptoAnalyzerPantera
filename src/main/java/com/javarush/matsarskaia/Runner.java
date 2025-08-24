package com.javarush.matsarskaia;

import com.javarush.matsarskaia.Command.Action;


public class Runner {
    public static void main(String[] args) {
        String inputFile = FileHandler.INPUT_FILE;
        String encryptedFile = FileHandler.ENCRYPTED_FILE;
        String decryptFile = FileHandler.DECRYPTED_FILE;

        int key = 8;


        Action action = ActionType.ENCODE.getAction();
        action.execute(inputFile,encryptedFile,key);
        System.out.println("Файл зашифрован с ключом " + key);

        Action action1 = ActionType.DECODE.getAction();
        action1.execute(encryptedFile,decryptFile,key);
        System.out.println("Файл расшифрован с ключом " + key);
    }
}
