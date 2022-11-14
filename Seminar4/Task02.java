import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Реализуйте очередь с помощью LinkedList со следующими методами:enqueue() -
 * помещает элемент в конец очереди, dequeue() - возвращает первый элемент из
 * очереди и удаляет его, first() - возвращает первый элемент из очереди, не
 * удаляя.
 */
public class Task02 {

    private static Queue<String> qList = new LinkedList<>();
    private static Boolean rez = true;
    public static void main(String[] args) {

        while (rez) {
            input();
        }
    }

    private static void input(){
        Scanner scan = new Scanner(System.in); 
        Integer numb = menu();

        switch (numb) {
            case  1:
                System.out.print("Введите знчание: ");
                String str = scan.next();
                enqueue(str);
                break;
            case 2:
                dequeue();
                break; 
            case 3:
                first();
                break;
            case 4:
                print();
                    break;
            case 5:
                System.out.println("Завершение программы.");
                rez = false;            
                return;
        }
    }

    private static Integer menu(){
        Scanner scan = new Scanner(System.in); 
        System.out.println("Выберете нужный пункт из меню:");
        System.out.println("1. Добавить в конец очереди.");
        System.out.println("2. Вернуть первый элемент из очереди и удаляет его.");
        System.out.println("3. Вернуть первый элемент из очереди, не удаляя.");
        System.out.println("4. Вывести все.");
        System.out.println("5. Выход.");
        System.out.print("Введите номер: ");
        Integer result = scan.nextInt();
        return result;
    }

    private static void print() {
        System.out.print("Очередь: ");        
        System.out.println(qList);        
    }

    // помещает элемент в конец очереди
    private static void enqueue(String str) {
        qList.add(str);
    }

    // возвращает первый элемент из очереди и удаляет его
    private static void dequeue() {
        System.out.println(qList.element());
        qList.poll();
    }

    // возвращает первый элемент из очереди, не удаляя
    private static void first() {
        System.out.println(qList.element());
    }
}
