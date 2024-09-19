package App;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Сryptographer {

    protected void encrypt(int key, Path path, Path pathOut, char[] alphabet) {

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toString()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut.toString()))
        ) {

            char[] chars = new char[50];
            char[] encryptChars = new char[50];

            int length;

            Map charsMap = Methods.charsToHashMap(alphabet); //сделаем из алфавита HashMap для быстрого поиска

//            System.out.println(charsMap);

            while (reader.ready()) {
                reader.read(chars);

                for (int i = 0; i < chars.length; i++) {

                    if (chars[i] != '\0') { //исключим пустые символы

                        boolean isUpperCase = false;

                        if (Character.isLetter(chars[i]) && Character.isUpperCase(chars[i])) {
                            isUpperCase = true;
                        }

                        char findChar = Character.isLetter(chars[i]) ? Character.toLowerCase(chars[i]) : chars[i]; //если буква, приводим к нижнему регистру, если символ то оставляем

                        if (charsMap.containsKey(findChar)) { // ищем букву в Hashmap

                            int findCharPosition = (int) charsMap.get(findChar); // получаем номер

                            int newPosition = findCharPosition + key;
                            if (newPosition >= alphabet.length) {
                                newPosition = newPosition - alphabet.length;
                            }

                            if (isUpperCase) {
                                encryptChars[i] = Character.toUpperCase(alphabet[newPosition]);
                            } else {
                                encryptChars[i] = alphabet[newPosition];
                            }
                        } else {
                            encryptChars[i] = chars[i];
                        }

                    }
                }

                writer.write(encryptChars);

            }

            writer.flush();

//            System.out.println(chars);
//            System.out.println(encryptChars);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void decrypt(int key, Path path, Path pathOut, char[] alphabet) {

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toString()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(pathOut.toString()))
        ) {

            char[] chars = new char[50];
            char[] decryptChars = new char[50];

            int length;

            Map charsMap = Methods.charsToHashMap(alphabet); //сделаем из алфавита HashMap для быстрого поиска

//            System.out.println(charsMap);

            while (reader.ready()) {
                reader.read(chars);

                for (int i = 0; i < chars.length; i++) {

                    if (chars[i] != '\0') { //исключим пустые символы


                        boolean isUpperCase = false;

                        if (Character.isLetter(chars[i]) && Character.isUpperCase(chars[i])) {
                            isUpperCase = true;
                        }
                        char findChar = Character.isLetter(chars[i]) ? Character.toLowerCase(chars[i]) : chars[i]; //если буква, приводим к нижнему регистру, если символ то оставляем


                        if (charsMap.containsKey(findChar)) { // ищем букву в Hashmap

                            int findCharPosition = (int) charsMap.get(findChar); // получаем номер

                            int newPosition = findCharPosition - key;
                            if (newPosition < 0) {
                                newPosition = alphabet.length + newPosition;
                            }
                            if (isUpperCase) {
                                decryptChars[i] = Character.toUpperCase(alphabet[newPosition]);
                            } else {
                                decryptChars[i] = alphabet[newPosition];
                            }
                        } else {
                            decryptChars[i] = chars[i];
                        }

                    }
                }

                writer.write(decryptChars);

            }

            writer.flush();

//            System.out.println(chars);
//            System.out.println(decryptChars);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
