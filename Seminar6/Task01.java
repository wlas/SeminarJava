import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 * 2. Создать множество ноутбуков.
 */
public class Task01 {

    public static void main(String[] args) {

       NetBook nBook0 = new NetBook();
       nBook0.setModel("GR300");
       nBook0.setCpu("i3 1500");
       nBook0.setMemory(4096);
       nBook0.setDisplay(16.5);
       nBook0.setSerialNumber(865186535);

       NetBook nBook1 = new NetBook();
       nBook1.setModel("GR301");
       nBook1.setCpu("i5 2500");
       nBook1.setMemory(4096);
       nBook1.setDisplay(15);
       nBook1.setSerialNumber(865186536);

       NetBook nBook2 = new NetBook();
       nBook2.setModel("GR303");
       nBook2.setCpu("i7 3500");
       nBook2.setMemory(8192);
       nBook2.setDisplay(17);
       nBook2.setSerialNumber(865186537);

       Set<NetBook> booksSet = new HashSet<>();
       booksSet.add(nBook0);
       booksSet.add(nBook1);
       booksSet.add(nBook2);

       System.out.println(booksSet);
    }   
}