package Map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class HashMapController {
    HashMap <String, int> cards = new HashMap<String, int>();
    HashMap <String, int> collection = new HashMap<String, int>();

    public void getCards (String url) throws IOException {
        ArrayList<String> cardSet = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(url));
        String a;

        while ((a = reader.readLine()) != null) cardSet.add(a);

        for (String s : cardSet) {
            String[] card = s.split("|");

        }


    }
}
