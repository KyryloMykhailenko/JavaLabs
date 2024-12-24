package lab5;

import java.util.Arrays;

public class Main {

    // Метод 1: Selection Sort (Сортування вибором)
    public static void selectionSortDescending(float[] array) {
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

    // Метод 2: Insertion Sort (Сортування вставками)
    public static void insertionSortDescending(float[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            float key = array[i];
            int j = i - 1;

            // Зміщуємо елементи, які менші за ключ, вправо
            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        // Тестовий масив
        float[] array1 = {5.2f, 3.1f, 7.8f, 1.6f, 4.4f};
        float[] array2 = Arrays.copyOf(array1, array1.length);

        System.out.println("Оригінальний масив:");
        System.out.println(Arrays.toString(array1));

        // Сортування методом Selection Sort
        selectionSortDescending(array1);
        System.out.println("Після сортування (Selection Sort):");
        System.out.println(Arrays.toString(array1));

        // Сортування методом Insertion Sort
        insertionSortDescending(array2);
        System.out.println("Після сортування (Insertion Sort):");
        System.out.println(Arrays.toString(array2));
    }
}
