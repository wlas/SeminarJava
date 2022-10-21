import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/** Задание 1* - Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.

Если значение null, то параметр не должен попадать в запрос.

Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
(Не sql запрос, я оговорился на вебинаре!)
Пример вывода:

Студент Иванов получил 5 по предмету Математика.

Студент Петрова получил 4 по предмету Информатика.

Студент Краснов получил 5 по предмету Физика.
 */
public class Task01 {

private static final String TAG_SURNAME = "фамилия";
private static final String TAG_VALUATION = "оценка";
private static final String TAG_ITEM = "предмет";

public static void main(String[] args) {
    String query = "select * from students where ";
    System.out.println(querySelect(query));
    System.out.println("++++++++++++++++++++++++++++++++++++");
    jsonPars();
}

private static StringBuilder querySelect(String query){
    
    StringBuilder sb = new StringBuilder();
    sb.append(query);
    sb.append(" age is not null");

    return sb;
}

private static void jsonPars(){
    try {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse("[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]");        
        
        for(Object it: jsonArray){
            JSONObject logbookJsonObject = (JSONObject) it;
            StringBuilder sb = new StringBuilder();
            String surname = (String)logbookJsonObject.get(TAG_SURNAME);
            String valution = (String)logbookJsonObject.get(TAG_VALUATION);
            String item = (String)logbookJsonObject.get(TAG_ITEM);
            sb.append("Студент " + surname + " получил " + valution + " по предмету " + item);
            System.out.println(sb.toString());
        }

    } catch (Exception e) {
        System.out.println("Ошибка парсинга " + e.toString());
    }
}
}