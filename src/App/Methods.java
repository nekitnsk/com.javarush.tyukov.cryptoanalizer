package App;

import java.util.HashMap;
import java.util.Map;

public class Methods {

    public static Map charsToHashMap(char[] chars){

        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            charMap.put(chars[i], i);
        }

        return charMap;
    }
}
