class MyCircularQueue {
    int[] arr;
    int front;
    int rear;
    int siz;
    int maxSiz;
    public MyCircularQueue(int k) {
        arr = new int[k];
        front = 0;
        rear = 0;
        siz = 0;
        maxSiz = k;
    }
    
    public boolean enQueue(int value) {
        if (siz == maxSiz) {
            return false;
        }
        siz++;
        arr[rear] = value;
        rear++;
        rear %= maxSiz;
        return true;
    }
    
    public boolean deQueue() {
        if (siz > 0) {
            front++;
            front %= maxSiz;
            siz--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        if (siz > 0) {
            return arr[front];
        }
        return -1;
    }
    
    public int Rear() {
        // System.out.println(Arrays.toString(arr));
        if (siz > 0) {
            int index = rear-1;
            if (index == -1) {
                index = maxSiz-1;
            }
            return arr[index];
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return siz == 0;
    }
    
    public boolean isFull() {
        return siz == maxSiz;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */