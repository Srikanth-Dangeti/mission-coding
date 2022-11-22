package dynamicProgrammingMCM;

import java.util.HashMap;
import java.util.Map;

public class ScrambledStringMemoization {

	private boolean isScramble(String s1, String s2, Map<String, Boolean> cache) {

        if (s1.equals(s2)) return true;
        if (s1.length() <= 1) return false;
        String cacheKey = s1 + " " + s2;
        if (cache.containsKey(cacheKey)) return cache.get(cacheKey);

        boolean flag = false;
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i), cache)
                && isScramble(s1.substring(i), s2.substring(i), cache)) {
                    flag = true;
                    break;
                }

            if (isScramble(s1.substring(0, i), s2.substring(n - i, n), cache)
                && isScramble(s1.substring(i, n), s2.substring(0, n - i), cache)) {
                    flag = true;
                    break;
                }
        }

        cache.put(cacheKey, flag);
        return flag;
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.isEmpty() && s2.isEmpty()) return true;

        HashMap<String, Boolean> cache = new HashMap<String, Boolean>();
        return isScramble(s1, s2, cache);
    }
}
