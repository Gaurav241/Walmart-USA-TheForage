import java.util.Arrays;
import java.util.NoSuchElementException;

public class PowerHeap {
    private double x;
    private int size;
    private int[] heapArray;

    // Constructor
    public PowerHeap(double x, int capacity) {
        this.size = 0;
        heapArray = new int[capacity + 1];
        this.x = x;
        Arrays.fill(heapArray, -1);
    }

    private int parent(int i) {
        return (int) ((i - 1) / Math.pow(2, x));
    }

    public boolean isFull() {
        return size == heapArray.length;
    }

    public void insert(int value) {
        if (isFull()) {
            throw new NoSuchElementException("Heap is full, no space to insert new element.");
        } else {
            heapArray[size++] = value;
            heapifyUp(size - 1);
        }
    }

    private void heapifyUp(int i) {
        int tmp = heapArray[i];
        while (i > 0 && tmp > heapArray[parent(i)]) {
            heapArray[i] = heapArray[parent(i)];
            i = parent(i);
        }
        heapArray[i] = tmp;
    }

    public int popMax() {
        int maxItem = heapArray[0];
        heapArray[0] = heapArray[size - 1];
        heapArray[size - 1] = -1;
        size--;

        int i = 0;
        while (i < size - 1) {
            heapifyUp(i);
            i++;
        }

        return maxItem;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heapArray[i]);
            System.out.print(',');
        }
        System.out.println();
    }

    public static void main(String[] args) {
        double x = 2; // Example value for x
        int capacity = 10; // Example capacity

        PowerHeap heap = new PowerHeap(x, capacity);
        heap.insert(5);
        heap.insert(10);
        heap.insert(3);

        heap.print();

        int maxItem = heap.popMax();
        System.out.println("Max item: " + maxItem);

        heap.print();
    }
}
