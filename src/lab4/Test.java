package lab4;

public class Test {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Парні елементи масиву:");
        for (int num : array) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }

    }
}