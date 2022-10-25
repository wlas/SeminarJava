import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */
public class Task02 {
    public static void main(String[] args) {
        int [] mas = {10, 4, 13, 17, 8};
        
        try {
            Logger logger = Logger.getAnonymousLogger();
        FileHandler fn = new FileHandler("log.txt");
        logger.addHandler(fn);

        SimpleFormatter sFormat = new SimpleFormatter();
        fn.setFormatter(sFormat);

        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            logger.info(Arrays.toString(mas)); 
            isSorted = true;
            for (int i = 0; i < mas.length-1; i++) {                 
                if(mas[i] > mas[i+1]){
                    isSorted = false;
                    
                    buf = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = buf;                                      
                }                                             
            }                          
        }
        System.out.println(Arrays.toString(mas));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.toString());
        }
    }
}
