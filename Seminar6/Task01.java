
/**
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 */
public class Task01 {

    public static void main(String[] args) {

       NetBook nBook = new NetBook();
       nBook.setModel("GR300");
       nBook.setCpu("i3 2500");
       nBook.setMemory(4096);
       nBook.setDisplay(16.5);
       nBook.setSerialNumber(865186535);

       System.out.println(nBook);
    }   
}