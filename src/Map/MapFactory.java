
package Map;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapFactory {

    public Map<String, String> getMap(int mapType){
        Map<String, String> myMap = null;

        switch (mapType) {
            //Hashmap
            case 1:
                myMap = new HashMap<String, String>();
                break;

            //TreeMap
            case 2:
                myMap = new TreeMap<String, String>();
                break;

            //LinkedHashMap
            default:
                myMap = new LinkedHashMap<String, String>();
                break;
        }

        return myMap;
        
    }
}
