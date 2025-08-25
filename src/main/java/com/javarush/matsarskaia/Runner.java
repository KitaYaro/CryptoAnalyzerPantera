package com.javarush.matsarskaia;



import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
        String inputFile = FileHandler.INPUT_FILE;
        String encryptedFile = FileHandler.ENCRYPTED_FILE;
        String decryptFile = FileHandler.DECRYPTED_FILE;
        String bruteFile = FileHandler.BRUTEFORCE_FILE;


        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int choice = readInt(scanner, "select an item from the menu: ");

            switch (choice) {
                case 1 -> {
                    int key = readInt(scanner,"enter key: ");
                    ActionType.ENCODE.getAction().execute(inputFile, encryptedFile, key);
                    System.out.println("the file is encrypted with key: " + key);
                }

                case 2 -> {
                    int key1 = readInt(scanner, "enter key: ");
                    ActionType.DECODE.getAction().execute(encryptedFile, decryptFile, key1);
                    System.out.println("the file is decrypted with key: " + key1);
                }

                case 3 -> {
                    ActionType.BRUTEFORCE.getAction().execute(encryptedFile, bruteFile, 0);
                    System.out.println("key found, file decrypted ");
                }

                case 4 -> {
                    System.out.println("Exit program ");
                    return;
                }
                default -> System.out.println(ConsoleColors.RED + "there is no menu item with this number" + ConsoleColors.RESET);
            }
        }
    }
    public static void showMenu (){
        System.out.println(ConsoleColors.GREEN + "1. ENCRYPTED" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "2. DECRYPTED" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "3. BRUTE_FORCE" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "4. EXIT" + ConsoleColors.RESET);
    }
    public static int readInt (Scanner scanner, String message){
        System.out.println(ConsoleColors.BLUE + message + ConsoleColors.RESET);
        while (!scanner.hasNextInt()){
            System.out.println(ConsoleColors.RED + "key must be a number!" + ConsoleColors.RESET);
            scanner.next();
        }
        return scanner.nextInt();
    }
}