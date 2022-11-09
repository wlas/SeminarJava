import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который
 * вернет "перевернутый список".
 */
public class Task01 {

    public static void main(String[] args) {

        List<String> list = new LinkedList<>(Arrays.asList("Один", "Два", "Три"));
        System.out.println(printReversList(list));
    }

    private static LinkedList<String> printReversList(List<String> llist) {

        LinkedList<String> revLinkedList = new LinkedList<String>();

        for (int i = llist.size() - 1; i >= 0; i--) {
            revLinkedList.add(llist.get(i));
        }

        return revLinkedList;
    }
}