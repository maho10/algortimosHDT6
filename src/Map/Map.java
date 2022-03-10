package Map;

import java.io.IOException;

public interface Map{
    public String showAllCards(boolean organized);
    public void getCards (String url) throws IOException;
    public boolean userCards(String name, int user);
    public String showCardType(String name);
    public String showCollection(int user, boolean organized);
}
