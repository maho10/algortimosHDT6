package Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory<E,S> {

    public Map<E,S> getMap(int mapType){
        return switch (mapType) {
            case 1 -> new HashMap<E,S>();
            case 2 -> new TreeMap<E,S>();
            case 3 -> new LinkedHashMap<E,S>();
            default -> null;
        };
    }
}
