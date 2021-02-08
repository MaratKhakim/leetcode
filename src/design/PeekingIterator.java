package design;

import java.util.Iterator;

/**
 * Date 08.02.2021.
 *
 * 284. Peeking Iterator
 *
 * Given an Iterator class interface with methods: next() and hasNext(),
 * design and implement a PeekingIterator that support the peek() operation --
 * it essentially peek() at the element that will be returned by the next call to next().
 *
 * https://leetcode.com/problems/peeking-iterator/
 */

public class PeekingIterator implements Iterator<Integer> {
    Integer next = null;
    Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            next = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasNext())
            return null;

        Integer temp = next;

        if (iterator.hasNext())
            next = iterator.next();
        else
            next = null;

        return temp;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
