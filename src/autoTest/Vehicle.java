package autoTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by nazar on 2/26/2017.
 */
public class Vehicle {
    public Map<String, String> mapa = new HashMap<String, String>() {
        {
            put("Car", "BMV");
            put("Motobike", "Suzuki");
            put("Motobike2", "Yamaha");

        }
    };
    ArrayList<String> states = new ArrayList<String>();

    public static void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    public void addStates() {
        states.add("Германия");
        states.add("Франция");
        states.add("Италия");
        states.add("Испания");

    }

    public void listForMap() {
        mapa.forEach((k, v) -> System.out.println("Key: " + k + ": Value: " + v));
    }

    public void listFor() {

        for (String item : states) {
            System.out.println(item);
        }
    }


}
