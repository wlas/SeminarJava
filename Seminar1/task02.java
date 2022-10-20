/*
 * Вывести все простые числа от 1 до 1000
 */
public class task02 {
    public static void main(String[] args) {
        for(int i = 2; i < 1000; i++){
            if(checkNum(i) == true){           
                System.out.print(i + ", ");
            }
        }
    }

    public static boolean checkNum(int number){
        boolean rez = true;
        for(int i = 2; i < number; i++){
            if(number % i == 0){
                rez = false;
                break;
            }
        } 
        return rez;
    }
}
