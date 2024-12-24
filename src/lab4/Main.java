package lab4;

public class Main {
    public static void main(String[] args) {
        // Виконання lab4.Task1
        System.out.println("Task 1:");
        int[] array1 = {-8, 6, -4, 0, 7, 12};
        int[] array2 = {-1, -3, 2, 4, -5};

        try {
            System.out.println("Result 1: " + Task1.findProduct(array1));
            System.out.println("Result 2: " + Task1.findProduct(array2));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // Виконання lab4.Task2
        System.out.println("\nTask 2:");
        int[] array3 = {10, 2, 30, -40, 50, 60, 70, 80, 90, -100, 110};
        int[] array4 = {1, 2, 3, 4, 5, 6};

        try {
            System.out.println("Max by modulus: " + Task2.findMaxModulusElement(array3));
            System.out.println("Max by modulus: " + Task2.findMaxModulusElement(array4));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // Виконання lab4.Task3
        System.out.println("\nTask 3:");
        int[] A = {1, 3, 5, 7};
        int[] B = {2, 4, 6, 8};

        try {
            int[] resultArray = Task3.mergeArrays(A, B);
            for (int num : resultArray) {
                System.out.print(num + " ");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

class Task1 {
    public static int findProduct(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        Integer maxNegative = null;
        Integer minEven = null;

        for (int num : array) {
            if (num < 0 && (maxNegative == null || num > maxNegative)) {
                maxNegative = num;
            }
            if (num % 2 == 0 && (minEven == null || num < minEven)) {
                minEven = num;
            }
        }

        if (maxNegative == null || minEven == null) {
            throw new IllegalArgumentException("Array does not contain required elements.");
        }

        return Math.abs(maxNegative * minEven);
    }
}

class Task2 {
    public static int findMaxModulusElement(int[] array) {
        if (array == null || array.length < 7) {
            throw new IllegalArgumentException("Array must have at least 7 elements.");
        }

        Integer maxModulusElement = null;

        for (int i = 0; i < array.length; i++) {
            if (i % 7 == 0) {
                if (maxModulusElement == null || Math.abs(array[i]) > Math.abs(maxModulusElement)) {
                    maxModulusElement = array[i];
                }
            }
        }

        if (maxModulusElement == null) {
            throw new IllegalArgumentException("No elements found at indices divisible by 7.");
        }

        return maxModulusElement;
    }
}

class Task3 {
    public static int[] mergeArrays(int[] A, int[] B) {
        if (A == null || B == null || A.length != B.length) {
            throw new IllegalArgumentException("Arrays must be non-null and of equal length.");
        }

        int n = A.length;
        int[] C = new int[2 * n];

        for (int i = 0; i < n; i++) {
            C[2 * i] = A[i];
            C[2 * i + 1] = B[i];
        }

        return C;
    }
}
