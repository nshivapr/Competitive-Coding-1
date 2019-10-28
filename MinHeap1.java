import java.util.Arrays;

class MinHeap {
    private int capacity = 10;
    private int size;
    private int heap[];
    public MinHeap() {
        heap = new int[capacity];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int peek() {
        if (isEmpty()) { throw new IllegalStateException(); }
        return heap[0];
    }

    public int remove() {
        if (isEmpty()) { throw new IllegalStateException(); }
        int minItem = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return minItem;
    }
    /*
      Add an item to the min heap
    */
    public void add(int itemToAdd) {
        ensureExtraCapacity();
        heap[size] = itemToAdd;
        size++;
        heapifyUp();
    }
    /**************************
     Heap restoration helpers
     **************************/
    private void heapifyDown() {
        int index = 0;

        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (heap[index] < heap[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }

    private void heapifyUp() {
        int index = size - 1;

        while (hasParent(index) && parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
    private void swap(int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }
    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }
    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }
    private int leftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }
    private int rightChild(int index) {
        return heap[getRightChildIndex(index)];
    }
    private int parent(int index) {
        return heap[getParentIndex(index)];
    }
}