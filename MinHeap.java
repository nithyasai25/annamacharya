import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Swap elements at indices i and j
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Insert a new value into the heap
    public void insert(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        // Bubble up
        while (i > 0 && heap.get(i) < heap.get((i - 1) / 2)) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    // Remove and return the minimum element (root)
    public int removeMin() {
        if (heap.size() == 0) {
            System.out.println("Heap is empty");
            return -1;
        }

        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (heap.size() > 0) {
            heap.set(0, last);
            heapify(0);
        }

        return min;
    }

    // Maintain min-heap property starting from index i
    private void heapify(int i) {
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < heap.size() && heap.get(l) < heap.get(smallest)) {
            smallest = l;
        }

        if (r < heap.size() && heap.get(r) < heap.get(smallest)) {
            smallest = r;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // Print the heap
    public void print() {
        System.out.println(heap);
    }

    // Main method for testing
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        int[] values = {10, 4, 15, 20, 0, 5, 2};
        for (int val : values) {
            minHeap.insert(val);
        }

        System.out.print("MinHeap array after inserts: ");
        minHeap.print();

        System.out.println("Removing min: " + minHeap.removeMin());
        System.out.print("MinHeap after removal: ");
        minHeap.print();
    }
}
