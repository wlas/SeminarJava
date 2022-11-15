import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
Пусть дан список сотрудников: 
Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */
public class Task02 {

    private static Map<String, String> dbList = new HashMap<>();
    public static void main(String[] args) {
        
        readFile();        
        searchName();
        var nList = searchName();
        System.out.println(sortedMap(nList));

    }

    private static void readFile(){
        try(FileReader reader = new FileReader("db.txt")){
            BufferedReader bRead = new BufferedReader(reader);
            String line = bRead.readLine();

            while (line != null) {
                String[] arr = line.split(" ");
                dbList.put(arr[1], arr[0]);
                line = bRead.readLine();
            }
        }
        catch(IOException ex){             
            System.out.println(ex.getMessage());
        }
    }

    private static TreeMap<String, Integer> searchName(){
        TreeMap<String, Integer> nameList = new TreeMap<>();        
        
        for (String key : dbList.keySet()) {
            
            if(!nameList.containsKey(dbList.get(key))){
                nameList.put(dbList.get(key), 1);
            }
            else{
                Integer overlap = nameList.get(dbList.get(key));
                nameList.put(dbList.get(key), ++overlap);
            }
        }
        return nameList;
    }

    private static Map<String,Integer> sortedMap(Map<String,Integer> db){
        var sortList = db.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (oldValue, newValue) -> oldValue,
                                        LinkedHashMap::new
                    ));
        return sortList;
    }
}

