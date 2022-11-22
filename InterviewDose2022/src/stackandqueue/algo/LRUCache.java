package stackandqueue.algo;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class CacheEntry{

    int key;
    int value;
    CacheEntry(int k, int v)
    {
        this.key = k;
        this.value = v;
    }
}
public class LRUCache {

    Deque<CacheEntry> list = new LinkedList<>();
    Map<Integer, CacheEntry> map = new HashMap<>();
    int CACHE_SIZE;

    LRUCache(int capacity)
    {
        this.CACHE_SIZE = capacity;
    }

    public void put(int key, int value)
    {
        if(map.containsKey(key))
        {
            CacheEntry entry = map.get(key);
            list.remove(entry);   
        }
        else
        {
            if(CACHE_SIZE == list.size())
            {
                CacheEntry entryToBeRemoved = list.removeLast();
                map.remove(entryToBeRemoved.key) ;
            }
        }

        CacheEntry newEntry = new CacheEntry(key, value);
        list.addFirst(newEntry);
        map.put(key, newEntry);
    }

    public int get(int key) {
        if(map.containsKey(key)) {
        CacheEntry entry = map.get(key);
        list.remove(entry);
        list.addFirst(entry);
        return entry.value;
    } 
    
    return -1;
    }
    public static void main(String[] args) {
        
    }
    
}
