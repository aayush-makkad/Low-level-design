package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// https://leetcode.com/problems/design-hashset/
public class DesignHashSet {


    /*
    Design a HashSet without using any built-in hash table libraries.

    Implement MyHashSet class:

    void add(key) Inserts the value key into the HashSet.
    bool contains(key) Returns whether the value key exists in the HashSet or not.
    void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

    Example

    Input
    ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
    [[], [1], [2], [1], [3], [2], [2], [2], [2]]
    Output
    [null, null, null, true, false, null, true, null, false]

    Explanation
    MyHashSet myHashSet = new MyHashSet();
    myHashSet.add(1);      // set = [1]
    myHashSet.add(2);      // set = [1, 2]
    myHashSet.contains(1); // return True
    myHashSet.contains(3); // return False, (not found)
    myHashSet.add(2);      // set = [1, 2]
    myHashSet.contains(2); // return True
    myHashSet.remove(2);   // set = [1]
    myHashSet.contains(2); // return False, (already removed)

    Constraints:

    0 <= key <= 10^6
    At most 104 calls will be made to add, remove, and contains.

     */

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // return False, (already removed)
    }

    public static class MyHashSet {


        class entry {
            private int key;

            public entry(int key) {
                this.key = key;
            }

            public int getKey() {
                return key;
            }
        }

        class Bucket {
            private final List<entry> listOfEntries;

            public Bucket(List<entry> listOfEntries) {
                this.listOfEntries = listOfEntries;
            }
        }

        int primeNumber = 2069;

        private final List<Bucket> listOfBuckets;

        private final int bucketsSize = 16;

        /** Initialize your data structure here. */
        public MyHashSet() {
            listOfBuckets = new ArrayList<>(bucketsSize);
             for(int i=0;i<bucketsSize;i++) {
                 listOfBuckets.add(new Bucket(new ArrayList<>()));
             }
        }

        public void add(int key) {
            int bucketIdx = ((key % this.primeNumber) % bucketsSize);
            entry keyEntry = new entry(key);
            Bucket bucket = this.listOfBuckets.get(bucketIdx);
            bucket.listOfEntries.add(keyEntry);
        }

        public void remove(int key) {
            int bucketIdx = ((key % this.primeNumber) % bucketsSize);
            Bucket bucket = this.listOfBuckets.get(bucketIdx);
            bucket.listOfEntries.removeIf(entry -> entry.getKey() == key);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int bucketIdx = ((key % this.primeNumber) % bucketsSize);
            Bucket bucket = this.listOfBuckets.get(bucketIdx);
            Iterator<entry> bucketIterator = bucket.listOfEntries.listIterator();
            while(bucketIterator.hasNext()) {
                entry next = bucketIterator.next();
                if(next.getKey() == key) {
                    return true;
                }
            }
            return false;
        }
    }
}
