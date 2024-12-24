package lab5;

public class Test {
    public static void main(String[] args) {
        int [] array = {64, 18, 10, 20, 36};
        System.out.println("сортування:");
        for (int num : array) {
            System.out.println(num + "");{

            }
        }
    }
    public void selectionSortDescending(float[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Обмін елементів
            float temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }
    }
}