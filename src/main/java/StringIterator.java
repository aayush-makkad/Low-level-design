import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/design-compressed-string-iterator/
 *
 * Design and implement a data structure for a compressed string iterator. The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.
 *
 * Implement the StringIterator class:
 *
 * next() Returns the next character if the original string still has uncompressed characters, otherwise returns a white space.
 * hasNext() Returns true if there is any letter needs to be uncompressed in the original string, otherwise returns false.
 *
 *
 * Example 1:
 *
 * Input
 * ["StringIterator", "next", "next", "next", "next", "next", "next", "hasNext", "next", "hasNext"]
 * [["L1e2t1C1o1d1e1"], [], [], [], [], [], [], [], [], []]
 * Output
 * [null, "L", "e", "e", "t", "C", "o", true, "d", true]
 *
 * Explanation
 * StringIterator stringIterator = new StringIterator("L1e2t1C1o1d1e1");
 * stringIterator.next(); // return "L"
 * stringIterator.next(); // return "e"
 * stringIterator.next(); // return "e"
 * stringIterator.next(); // return "t"
 * stringIterator.next(); // return "C"
 * stringIterator.next(); // return "o"
 * stringIterator.hasNext(); // return True
 * stringIterator.next(); // return "d"
 * stringIterator.hasNext(); // return True
 */

class StringIterator {

    private final Queue<Character> characterQueue;

    public StringIterator(String compressedString) {
        characterQueue = new LinkedList<>();
        int idx = 0;
        while(idx<compressedString.length()){
            char characterToUse = compressedString.charAt(idx);
            idx++;
            int timesToRepeat = 0;
            int base = 1;
            while(idx<compressedString.length() && Character.isDigit(compressedString.charAt(idx))) {
                timesToRepeat = (timesToRepeat * base) + (compressedString.charAt(idx) - '0');
                base*=10;
                idx++;
            }
            int occurrences = 0;
            while(occurrences < timesToRepeat) {
                characterQueue.add(characterToUse);
                occurrences++;
            }
        }
    }

    public char next() {
        return !characterQueue.isEmpty() ? characterQueue.poll() : ' ';
    }

    public boolean hasNext() {
        return !characterQueue.isEmpty();
    }
}
