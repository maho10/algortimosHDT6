package Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class MapController<E, S> {

    private MapFactory<String, Integer> map = new MapFactory<String, Integer>();
    private MapFactory<Integer, ArrayList<String>> map2 = new MapFactory<Integer, ArrayList<String>>();
    private Map<String, Integer> cards;
    private Map <Integer, ArrayList<String>> collection;
    private Map<String, Integer> userCC;


    public MapController(int type){
        cards = map.getMap(type);
        userCC = map.getMap(type);
        collection = map2.getMap(type);
    }

    public void getCards (String url) throws IOException {
        ArrayList<String> cardSet = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("cards_desc.txt"));
        String a;

        while ((a = reader.readLine()) != null) cardSet.add(a);

        for (String s : cardSet) {
            String[] card = s.split("\\|");
            String name = card[0];
            int type = switch (card[1].toUpperCase()) {
                case "MONSTRUO" -> 1;
                case "TRAMPA" -> 2;
                case "HECHIZO" -> 3;
                default -> 0;
            };
            cards.put(name, type);

        }

    }

    public boolean userCards(String name, int user){
        ArrayList<String> newCard = new ArrayList<>();
        newCard.add(name);
        if(cards.get(name) != null){
            if(collection.get(user) != null){
                collection.get(user).add(name);
            } else collection.put(user, newCard);
            return true;
        } else return false;
    }

    public String showCardType(String name){
        return switch (cards.get(name)) {
            case 1 -> "Monstruo";
            case 2 -> "Trampa";
            case 3 -> "Hechizo";
            default -> "La carta ingresada no existe";
        };
    }

    public String showCollection(int user, boolean organized){

        StringBuilder card = new StringBuilder("");
        StringBuilder monster = new StringBuilder("Monstruos\n-------------------------\n");
        StringBuilder spell = new StringBuilder("Hechizos\n-------------------------\n");
        StringBuilder trap = new StringBuilder("Trampas\n-------------------------\n");
        ArrayList<String> userCollection = collection.get(user);

        Collections.sort(userCollection);
        String repeat = "";

        for (String value : userCollection) {
            if (repeat.equals(value)) {
                userCC.put(value, userCC.get(value) + 1);
            } else {
                repeat = value;
                userCC.put(value, 1);
            }
        }

        if(!organized){
            for(String s: userCC.keySet()){
                int cardType = cards.get(s);
                switch (cardType) {
                    case (1) -> card.append(s).append("| Monstruo, ").append(userCC.get(s)).append("\n");
                    case (2) -> card.append(s).append("| Trampa, ").append(userCC.get(s)).append("\n");
                    case (3) -> card.append(s).append("| Hechizo, ").append(userCC.get(s)).append("\n");
                }

            }
        } else {
            for (String s: userCC.keySet()){
                int cardType = cards.get(s);
                switch (cardType) {
                    case (1) -> monster.append(s).append(", ").append(userCC.get(s)).append("\n");
                    case (2) -> trap.append(s).append(", ").append(userCC.get(s)).append("\n");
                    case (3) -> spell.append(s).append(", ").append(userCC.get(s)).append("\n");
                }
            }

            card.append(monster).append(trap).append(spell);
        }
        return String.valueOf(card);
    }

    public String showAllCards(boolean organized){
        StringBuilder monster = new StringBuilder("Monstruos\n-------------------------\n");
        StringBuilder spell = new StringBuilder("Hechizos\n-------------------------\n");
        StringBuilder trap = new StringBuilder("Trampas\n-------------------------\n");
        StringBuilder card = new StringBuilder("");

        if(!organized){
            for(String s: cards.keySet()){
                int cardType = cards.get(s);
                switch (cardType) {
                    case (1) -> card.append(s).append("| Monstruo, ").append("\n");
                    case (2) -> card.append(s).append("| Trampa, ").append("\n");
                    case (3) -> card.append(s).append("| Hechizo, ").append("\n");
                }

            }
        } else {
            for (String s: cards.keySet()){
                int cardType = cards.get(s);
                switch (cardType) {
                    case (1) -> monster.append(s).append(", ").append("\n");
                    case (2) -> trap.append(s).append(", ").append("\n");
                    case (3) -> spell.append(s).append(", ").append("\n");
                }
            }

            card.append(monster).append(trap).append(spell);
        }
        return String.valueOf(card);
    }
}
