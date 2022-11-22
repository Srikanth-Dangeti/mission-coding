package util;

import java.util.Map;

public class CodeHelper {

    public static  <K, V> K getKey(Map<K, V> map, V valueFromMap)
    {
        for(K key : map.keySet())
        {
            if(valueFromMap.equals(map.get(key)))
            {
                return key;
            }
        }
        return null;
    }
}
