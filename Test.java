package enums;

import java.io.File;
import java.nio.file.Path;

public class Test {

    public static void main(String[] args){
        Path path = Path.of("0e4cd496fdcfd639dfd0cd1defabb166.webm");
        File file = new File(String.valueOf(path.getFileName()));
        File newFile = new File(path+".mp4");
        boolean success =  file.renameTo(newFile);
        if(success){
            System.out.println("File is successfully renamed");
        }
    }
}