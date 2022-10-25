import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * К калькулятору из предыдущего дз добавить логирование.
 */
public class Task04 {

    private static int value1;
    private static int value2;
    private static Character value3 = null;    

    public static void main(String[] args) {
        try {
            Logger logger = Logger.getAnonymousLogger();
            FileHandler fn = new FileHandler("calc_logs.txt");
            logger.addHandler(fn);

            SimpleFormatter sFormat = new SimpleFormatter();
            fn.setFormatter(sFormat);

            values();

            String str = value1 + " " + value3 + " " + value2 + " = " + operations(value3);
            System.out.println(str);
            logger.info(str);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.toString());
        }
    }

    public static void values(){       
        
        value1 = inputValue("первое");
        value3 = inputMath();
        value2 = inputValue("второе");
    }
    
    public static int inputValue(String str){

        int value = 0;
        boolean rez = false; 
        
        while(rez == false) {
            try { 
                Scanner scan = new Scanner(System.in);                  
                System.out.print("Введите " + str + " значание: ");
                value = scan.nextInt();
                rez = true;           
    
            } catch (Exception e) {
                System.out.println("Ошибка ввода, повторите попытку.");                    
            }
        }
        return value;
    }
    public static char inputMath(){
        Character value = null;
        try {
            Scanner scan = new Scanner(System.in);
            while (value == null) {
                System.out.print("Ввидите символ арифметического действия: ");
                char result = scan.next().charAt(0);                 
                if(searchMath(result) == true){
                    value = result;
                }                 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    private static Boolean searchMath(char str){
        boolean rez = false;
        char[] arrayChar = new char[]{'/','*','-','+'};

        for (char c : arrayChar) {
            if(c == str){
                rez = true;
                break;
            }
        }
        return rez;
    }

    private static int operations(char key){
        int result;
        switch (key) {
            case '+': result = value1 + value2; break;
            case '-': result = value1 - value2; break;
            case '*': result = value1 * value2; break;
            case '/': result = value1 / value2; break;        
            default: result = 0;
        }
        return result;
    }
}
