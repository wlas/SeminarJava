import java.io.File;

/*
Задание 3 - Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
1 Расширение файла: txt

2 Расширение файла: pdf

3 Расширение файла:

4 Расширение файла: jpg

Задание 4 - К калькулятору из предыдущего дз добавить логирование.
 */

public class Task03 {
    public static void main(String[] args) {
        listFile();
    }

    private static void listFile(){
        File folder = new File("d:/");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println("Файл: " + file.getName() + ". Тип расширения: " + getExtension(file));
            }
        }
    }

    private static String getExtension(File file){

        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; 
        }
        return name.substring(lastIndexOf);
    }
}
