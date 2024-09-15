package App;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int key = 0;
        Menu menu = new Menu();

        System.out.println("Шифровщик файлов по алгоритму Шифра Цезаря");

        int chooseAction = menu.chooseAction(); //Выводим меню ввода действия

        if (chooseAction == 1) { //Если выбрано шифарование файла
            key = menu.chooseKey(); // выводим меню ввода ключа шифрования
            Path inputFilePath = menu.chooseInputFilePath(); //выводим меню ввода пути файла
            Path outputFilePath = menu.chooseOutputFilePath(); // выводим меню ввода выходного файла

            Сryptographer crypto = new Сryptographer();
            crypto.encrypt(key, inputFilePath, outputFilePath, Alphabet.ALPHABET_RUS);



        } else if (chooseAction == 2) { //если выбрано дешифрование
            key = menu.chooseKey();

            Path inputFilePath = menu.chooseInputFilePath(); //выводим меню ввода пути файла
            Path outputFilePath = menu.chooseOutputFilePath(); // выводим меню ввода выходного файла

            Сryptographer crypto = new Сryptographer();
            crypto.decrypt(key, inputFilePath, outputFilePath, Alphabet.ALPHABET_RUS);

        }


    }
}