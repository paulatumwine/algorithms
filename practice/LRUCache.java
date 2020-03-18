public class LRUCache {

    class Entry {
        Integer key;
        Integer value;
        Entry left;
        Entry right;
    }

    java.util.Map<Integer, Entry> cacheMap = new java.util.HashMap();
    final int CAP;
    Entry start, end;

    public LRUCache(int capacity) {
        CAP = capacity;
    }

    public int get(int key) {
        /**
         * get value from entry in cacheMap
         * move it to front of Doubly Linked List;
         * which is a 2 step process:
         * remove it from wherever it is in the list,
         * and then add it to the top
         */
        if (cacheMap.containsKey(key)) {
            Entry entry = cacheMap.get(key);
            removeEntry(entry);
            addToTop(entry);
            return entry.value;
        }
        return -1;
    }

    private void removeEntry(Entry entry) {
        if (entry.left != null) entry.left.right = entry.right;
        else start = entry.right;

        if (entry.right != null) entry.right.left = entry.left;
        else end = entry.left;
    }

    private void addToTop(Entry entry) {
        entry.right = start;
        entry.left = null;
        if (start != null) start.left = entry;
        start = entry;
        if (end == null) end = start;
    }

    public void put(int key, int value) {
        /**
         * 3 scenarios:
         * 1- key exists in cacheMap; update value & move it to top
         * 2- cache is full
         * 3- cache still has space
         */
        if (cacheMap.containsKey(key)) {
            Entry entry = cacheMap.get(key);
            entry.value = value;
            removeEntry(entry);
            addToTop(entry);
        } else {
            Entry newEntry = new Entry();
            newEntry.key = key;
            newEntry.value = value;
            // leave newEntry right and left null
            if (cacheMap.size() >= CAP) {
                cacheMap.remove(end.key);
                removeEntry(end);
                addToTop(newEntry);
            } else {
                addToTop(newEntry);
            }
            cacheMap.put(key, newEntry);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */