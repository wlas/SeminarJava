import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task02 {
    /*
     * Пусть дан произвольный список целых чисел, удалить из него четные числа
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

            ArrayList<Integer> list = evenNumbers(numbs);
            if(list != null){
                String listString2 = list.toString();
                logger.info(listString2);
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.toString());
        }
        
    }

    public static ArrayList<Integer> evenNumbers(ArrayList<Integer> list){        

        for(int i = 0; i < list.size(); i++){

            if(list.get(i).intValue() % 2 == 0){
                list.remove(i);
                list.trimToSize();
            }
        }
        return list;
    }
}
