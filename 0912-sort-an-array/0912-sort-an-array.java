class Heap {
    int[] arr;
    int size;
    public Heap(int siz) {
        int newSiz = 1;
        while (newSiz < siz) {
            newSiz *= 2;
        }
        arr = new int[newSiz+1];
        size = 0;
    }
    public void add(int val) {
        size++;
        arr[size] = val;
        upperDirection(size);
        // System.out.println("add: "+Arrays.toString(arr));
    }
    public int pop() {
        int result = arr[1];
        arr[1] = arr[size];
        size--;
        lowerDirection();
        // System.out.println("pop: "+Arrays.toString(arr));
        return result;
    }
    public void upperDirection(int pos) {
        while (pos != 1) {
            int parent = pos/2;
            if (arr[parent] > arr[pos]) {
                int tmp = arr[parent];
                arr[parent] = arr[pos];
                arr[pos] = tmp;
                pos /= 2;
            }
            else {
                break;
            }
        }
    }
    public void lowerDirection() {
        int cur = 1;
        while (cur < size) {
            int leftChildPos = cur*2;
            int rightChildPos = cur*2+1;
            if (leftChildPos > size) {
                break;
            }
            int c = arr[cur];
            if (rightChildPos <= size) {
                int lc = arr[leftChildPos];
                int rc = arr[rightChildPos];
                if (c > lc && lc < rc) {
                    arr[cur] = lc;
                    arr[leftChildPos] = c;
                    cur = leftChildPos;
                }
                else if (c > rc) {
                    arr[cur] = rc;
                    arr[rightChildPos] = c;
                    cur = rightChildPos;
                }
                else {
                    break;
                }
            }
            else {
                int lc = arr[leftChildPos];
                if (c > lc) {
                    arr[cur] = lc;
                    arr[leftChildPos] = c;
                    cur = leftChildPos;
                }
                else {
                    break;
                }
                cur = leftChildPos;
            }
        }
    }
}

class Solution {
    public int[] sortArray(int[] nums) {
        Heap h = new Heap(nums.length);
        for (int num : nums) {
            h.add(num);
        }
        for (int i=0; i<nums.length; i++) {
            nums[i] = h.pop();
        }
        return nums;
    }
}

/*
[3,-1]
*/