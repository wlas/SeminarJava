import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelBase {

    private Map<String, List<String>> dbTel = new HashMap<>();
    private List<String> phoneList;

    public void addUser(String surname, String number){
        if (dbTel.containsKey(surname)) {
            phoneList = dbTel.get(surname);
            phoneList.add(number);
            dbTel.put(surname, phoneList);
        } else {
            phoneList = new ArrayList<>();
            phoneList.add(number);
            dbTel.put(surname, phoneList);
        }
    }

    public List<String> get(String surname) {
        return dbTel.get(surname);
    }
}
