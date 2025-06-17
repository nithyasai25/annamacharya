public class optimizedbubblesort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Last i elements are already sorted
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements if in wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps occurred, array is sorted
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 25, 12, 22, 11};

        System.out.println("Before sorting:");
        printArray(data);

        bubbleSort(data);

        System.out.println("After sorting:");
        printArray(data);
    }

    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
