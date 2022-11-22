import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 1. Подумать над структурой класса Ноутбук для магазина техники - выделить
 * поля и методы. Реализовать в java.
 * 2. Создать множество ноутбуков.
 * 3. Написать метод, который будет запрашивать у пользователя критерий (или
 * критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии
 * фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую
 * необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 */
public class Task01 {

    private static Set<NetBook> booksSet = new HashSet<>();
    private static Boolean rez = true;

    public static void main(String[] args) {

        NetBook nBook0 = new NetBook();
        nBook0.setModel("TR300");
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

        booksSet.add(nBook0);
        booksSet.add(nBook1);
        booksSet.add(nBook2);

        while (rez) {
            input();
        }

    }

    private static void input(){
        Scanner scan = new Scanner(System.in); 
        Integer numb = menuSearch();

        switch (numb) {
            case  1:
                System.out.print("Введите модель: ");
                String str = scan.next();
                System.out.println(filterModel(str)); 
                break;
            case 2:
                System.out.print("Введите название CPU: ");
                String str1 = scan.next();
                System.out.println(filterCpu(str1)); 
                break; 
            case 3:
                System.out.print("Введите объем памяти: ");
                Integer str2 = scan.nextInt();
                System.out.println(filterMemory(str2)); 
                break;
            case 4:
                System.out.print("Введите серийный номер: ");
                Integer str3 = scan.nextInt();
                System.out.println(filterSerialNumber(str3)); 
                    break;
            case 5:
                System.out.println("Завершение программы.");
                rez = false;            
                return;
        }
    }

    private static Integer menuSearch(){
        Scanner scan = new Scanner(System.in); 
        System.out.println("Выберете пункт критерия из меню:");
        System.out.println("1. Model.");
        System.out.println("2. CPU.");
        System.out.println("3. Memory.");
        System.out.println("4. Серийный номер.");
        System.out.println("5. Выход.");
        System.out.print("Введите номер: ");
        Integer result = scan.nextInt();
        return result;
    }

    private static Set<NetBook> filterModel(String str){        

        return booksSet.stream().filter(n -> n.getModel().equals(str)).collect(Collectors.toSet());
    }
    private static Set<NetBook> filterCpu(String str){        

        return booksSet.stream().filter(n -> n.getCpu().equals(str)).collect(Collectors.toSet());
    }
    private static Set<NetBook> filterMemory(Integer str){        

        return booksSet.stream().filter(n -> n.getMemory().equals(str)).collect(Collectors.toSet());
    }
    private static Set<NetBook> filterSerialNumber(Integer str){        

        return booksSet.stream().filter(n -> n.getSerialNumber().equals(str)).collect(Collectors.toSet());
    }
}