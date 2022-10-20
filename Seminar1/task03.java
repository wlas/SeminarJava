import java.util.Scanner;

/*
 * Реализовать простой калькулятор
 */
public class task03 {

    private static int value1;
    private static int value2;
    private static Character value3 = null;

    public static void main(String[] args) {
        Values();
        System.out.println(value1 + " " + value3 + " " + value2 + " = " + Operations(value3) );
    }

    public static void Values(){       
        
        value1 = InputValue("первое");
        value3 = InputMath();
        value2 = InputValue("второе");
    }
    
    public static int InputValue(String str){

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
    public static char InputMath(){
        Character value = null;
        try {
            Scanner scan = new Scanner(System.in);
            while (value == null) {
                System.out.print("Ввидите символ арифметического действия: ");
                char result = scan.next().charAt(0);                 
                if(SearchMath(result) == true){
                    value = result;
                }                 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    private static Boolean SearchMath(char str){
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

    private static int Operations(char key){
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
