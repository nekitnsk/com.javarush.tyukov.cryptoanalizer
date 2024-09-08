package App;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    //Просто проверка существования файла
    protected static boolean checkFileExist(Path path){
        boolean isFileExist = false;
        if(Files.exists(path)){
            isFileExist = true;
        }
        return isFileExist;
    }


    //Проверка что представлен текстовый файл
    protected static boolean checkFileType(Path path) {

        boolean isFileTypeTxt = false;

        try {
            String mimeType = Files.probeContentType(path);

            if(mimeType == "text/plain"){
                isFileTypeTxt = true;
            }
        }catch (IOException e){
            System.out.println("Ошибка доступа к файлу");
        }


        return isFileTypeTxt;
    }


}
