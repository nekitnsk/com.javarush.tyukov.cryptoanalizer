package App;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    //Просто проверка существования файла
    protected static boolean checkFileExist(Path path) {
        boolean isFileExist = false;
        if (Files.exists(path)) {
            isFileExist = true;
        }
        return isFileExist;
    }


    //Проверка что представлен текстовый файл
    protected static boolean checkFileType(Path path) {

        boolean isFileTypeTxt = false;


        String fileName = path.getFileName().toString();

        int lastDotIndex = fileName.lastIndexOf('.');

        // Проверка на наличие точки в имени файла
        String fileExt = "";
        if (lastDotIndex > 0 && lastDotIndex < fileName.length() - 1) {
            fileExt = fileName.substring(lastDotIndex + 1);
        }

        if (fileExt.equals("txt")) {
            isFileTypeTxt = true;
        }


        return isFileTypeTxt;
    }

    protected static boolean createFile(Path path){
        boolean created = false;

        try{
            Files.createFile(path);
            created = true;

        }catch(IOException e){
            created = false;
        }

        return created;
    }



}
