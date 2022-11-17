
/**
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */
public class Task01 {

    public static void main(String[] args) {

       TelBase db = new TelBase();

       db.addUser("Smernov", "89999210564");
       db.addUser("Smernov", "89999210555");
       db.addUser("Petrov", "89923434555");

       System.out.println(db.get("Smernov"));
        System.out.println(db.get("Petrov"));
    }   
}