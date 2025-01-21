/*Create a program that encrypts or decrypts the contents of a text file using a simple encryption algorithm. Prompt the user to choose between encryption or decryption, and input the file name or path. Encrypt or decrypt the file accordingly and save the result to a new file.*/

import java.io.*;
import java.util.Scanner;

public class FileEncryptionDecryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user for encryption or decryption
        System.out.println("Choose an option (1: Encrypt, 2: Decrypt): ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Prompt user for file name or path
        System.out.println("Enter the file name or path: ");
        String filePath = sc.nextLine();

        // Prompt user for the shift value
        System.out.println("Enter the shift value: ");
        int shift = sc.nextInt();

        // Perform encryption or decryption
        if (choice == 1) {
            encryptFile(filePath, shift);
        } else if (choice == 2) {
            decryptFile(filePath, shift); 
        } else {
            System.out.println("Invalid option. Please choose 1 or 2.");
        }

        sc.close();
    }

    public static void encryptFile(String filePath, int shift) {
        processFile(filePath, shift, true);
    }

    public static void decryptFile(String filePath, int shift) {
        processFile(filePath, -shift, false);
    }

    public static void processFile(String filePath, int shift, boolean isEncrypt) {
        File inputFile = new File(filePath);
        File outputFile = new File(isEncrypt ? "encrypted_" + inputFile.getName() : "decrypted_" + inputFile.getName());

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String processedLine = shiftString(line, shift);
                writer.write(processedLine);
                writer.newLine();
            }

            System.out.println((isEncrypt ? "Encryption" : "Decryption") + " completed. Output file: " + outputFile.getPath());

        } catch (IOException e) {
            System.out.println("An error occurred while processing the file: " + e.getMessage());
        }
    }

    public static String shiftString(String input, int shift) {
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char) ((ch - base + shift + 26) % 26 + base);
            }
            result.append(ch);
        }

        return result.toString();
    }
}



