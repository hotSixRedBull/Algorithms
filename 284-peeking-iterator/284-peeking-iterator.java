// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    int pointer;
    int siz;
    int[] arr;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    pointer = 0;
        arr = new int[1001];
        int tmpPointer = 0;
        while (iterator.hasNext()) {
            arr[tmpPointer++] = iterator.next();
            siz++;
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return arr[pointer];
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return arr[pointer++];
	}
	
	@Override
	public boolean hasNext() {
	    return pointer < siz;
	}
}