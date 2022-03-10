package Map;

public class MapFactory {

    public Map getMap(int mapType){
        return switch (mapType) {
            case 1 -> new HashMapController();
            case 2 -> new TreeMapController();
            case 3 -> new LinkedHashMapController();
            default -> null;
        };
    }
}
