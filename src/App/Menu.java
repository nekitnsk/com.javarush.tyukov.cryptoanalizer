package App;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class Menu {

    protected static final int LEN = Alphabet.ALPHABET_RUS.length;


    //Выводи меню выбора действия
    protected int chooseAction() {
        System.out.println("Выберите действие, которое хотить произвести:");
        System.out.println("1 - Зашифровать файл");
        System.out.println("2 - Дешифровать файл");
        System.out.println("3 - Выход");

        Scanner console = new Scanner(System.in);
        int chooseAction = 3;

        try {
            chooseAction = Integer.parseInt(console.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Введите номер пункта цифрами, без текста");
            chooseAction();
        }

        if (chooseAction < 1 && chooseAction > 3) {
            System.out.println("Введите значение от 1 до 3 из представленных в меню");
            chooseAction();
        }

        return chooseAction;
    }


    //Меню ввода ключа и проверка требований ключа
    protected int chooseKey() {
        System.out.println("Введите ключ шифрования от 1 до " + LEN);
        Scanner console = new Scanner(System.in);
        int key = 1;

        try {
            key = Integer.parseInt(console.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Введите ключ цифрами, без текста и пробелов от 1 до " + LEN);
            chooseKey();
        }

        if (key < 1 && key > LEN) {
            System.out.println("Введите ключ от 1 до " + LEN);
            chooseKey();
        }

        return key;
    }

    //Меню ввода входящего файла и проверка существования и типа файла
    protected Path chooseInputFilePath() {

        System.out.println("Введите путь к исходному текстовому файлу");
        Scanner console = new Scanner(System.in);
        Path path = Path.of(console.nextLine());

        if (!FileHandler.checkFileExist(path)) {
            System.out.println("Такой файл не найден, повторите ввод пути к файлу");
            chooseInputFilePath();
        } else {
            if (!FileHandler.checkFileType(path)) {
                System.out.println("Выбранный файл имеет неверный тип, введите путь к текстовому файлу");
                chooseInputFilePath();
            } else {
                return path;
            }
        }

        return path;
    }

    protected Path chooseOutputFilePath() {
        System.out.println("Введите путь к текстовому файлу, куда хотите выгрузить данные");
        Scanner console = new Scanner(System.in);
        Path path = Path.of(console.nextLine());

        if(FileHandler.checkFileExist(path)){
            return path;
        }else {
            if(FileHandler.createFile(path)){
                return path;
            }else {
                System.out.println("Ошибка при создании файла, попробуйте другой путь");
                chooseOutputFilePath();
            }
        }

        return path;
    }
}
