package Others;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {
    
  class CacheEntry {
  int key; 
  int value; 
  
  CacheEntry(int key, int value) {
    this.key = key;
    this.value = value;
  }
}  
  Deque<CacheEntry> q = new LinkedList<>();
  Map<Integer, CacheEntry> map = new HashMap<>();
   int CACHE_SIZE; 
   
    public LRUCache(int capacity) {
        CACHE_SIZE = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
        CacheEntry entry = map.get(key);
        q.remove(entry);
        q.addFirst(entry);
        return entry.value;
    } 
    
    return -1;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)) { 
      CacheEntry entry = map.get(key);
      q.remove(entry);
    } else {
      if(q.size() == CACHE_SIZE) {
        CacheEntry entryToBeRemoved = q.removeLast();
        map.remove(entryToBeRemoved.key);
      }
    }

    CacheEntry newEntry = new CacheEntry(key, value);
    q.addFirst(newEntry);
    map.put(key, newEntry);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */