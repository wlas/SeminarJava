import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task03 {
    /*
     *  Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
     */    

    public static void main(String[] args) {
        
        try {
            Logger logger = Logger.getAnonymousLogger();
            FileHandler fn = new FileHandler("logs.txt");
            logger.addHandler(fn);
            SimpleFormatter sFormat = new SimpleFormatter();
            fn.setFormatter(sFormat);

            ArrayList<Integer> numbs = new ArrayList<Integer>(Arrays.asList(7, 2, 4, 77, 55, 5, 6));
            String listString = numbs.toString();
            logger.info(listString);
            logger.info("Максимальное значание: " + Collections.max(numbs).toString());
            logger.info("Минимальное значание: " + Collections.min(numbs).toString());

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.toString());
        }
         
    }
}
