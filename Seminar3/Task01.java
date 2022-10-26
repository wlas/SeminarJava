
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/**
 * Реализовать алгоритм сортировки слиянием
 */
public class Task01 {
    public static void main(String[] args) {

        try {
            Logger logger = Logger.getAnonymousLogger();
            FileHandler fn = new FileHandler("logs.txt");
            logger.addHandler(fn);
            SimpleFormatter sFormat = new SimpleFormatter();
            fn.setFormatter(sFormat);

            int[] array1 = { 7, 0, -2, 6, 7, 10, 8, -4, 2, -88, 53 };
            logger.info(Arrays.toString(array1));
            int[] result = mergesort(array1);
            logger.info(Arrays.toString(result));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.toString());
        }        
    }

    public static int[] mergesort(int[] array1) {
        int[] buffer1 = Arrays.copyOf(array1, array1.length);
        int[] buffer2 = new int[array1.length];
        int[] result = mergesortInner(buffer1, buffer2, 0, array1.length);
        return result;
    }

    public static int[] mergesortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }
        
        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);
        
        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2] ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
       
}