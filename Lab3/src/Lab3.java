public class Lab3 {

    public static void main(String[] args) {
        // Тестування Завдання 1
        System.out.println("Завдання 1:");
        printSumResults(1, 1, 30);
        printSumResults(2, 5, 20);
        printSumResults(10, 0, 15);
        printSumResults(2, 3, 31);  // Повинно викликати виключення
        printSumResults(2, 3, 0);   // Повинно викликати виключення

        // Тестування Завдання 2
        System.out.println("\nЗавдання 2:");
        printXResults(4, 1);
        printXResults(9, 2);
        printXResults(5, 3);
        printXResults(10, 0);  // Повинно викликати виключення

        // Тестування Завдання 3
        System.out.println("\nЗавдання 3:");
        printInfiniteSumResults(0.001);
        printInfiniteSumResults(0.0001);
        printInfiniteSumResults(-0.1);  // Повинно викликати виключення
    }

    // Завдання 1: Обчислити суму ряду
    public static double calculateSum(double a, double b, int k) {
        if (k < 1 || k > 30) {
            throw new IllegalArgumentException("k має бути в діапазоні 1 <= k <= 30. k = " + k);
        }

        double sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += Math.sqrt(a * i * (b / i));
        }
        return sum;
    }

    static void printSumResults(double a, double b, int k) {
        System.out.print("a:" + a + " b:" + b + " k:" + k + " result:");
        try {
            System.out.println(calculateSum(a, b, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }

    // Завдання 2: Обчислити значення функції
    public static double calculateX(double t, int i) {
        if (t <= 0) {
            throw new IllegalArgumentException("t має бути більше за 0. t = " + t);
        }

        if (i == 1) {
            return Math.sqrt(t);
        } else if (i == 2) {
            return 1 / Math.sqrt(t);
        } else if (i > 2) {
            double sum = 0;
            for (int k = 1; k <= t; k++) {
                sum += k * t;
            }
            return sum;
        } else {
            throw new IllegalArgumentException("i має бути натуральним числом. i = " + i);
        }
    }

    static void printXResults(double t, int i) {
        System.out.print("t:" + t + " i:" + i + " result:");
        try {
            System.out.println(calculateX(t, i));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }

    // Завдання 3: Обчислити нескінченну суму
    public static double calculateInfiniteSum(double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("epsilon має бути більше за 0. epsilon = " + epsilon);
        }

        double sum = 0;
        double term;
        int i = 1;

        do {
            term = Math.pow(-1, i) / factorial(i);
            sum += term;
            i++;
        } while (Math.abs(term) > epsilon);

        return sum;
    }

    public static double factorial(int n) {
        if (n == 0) return 1;
        double fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    static void printInfiniteSumResults(double epsilon) {
        System.out.print("epsilon:" + epsilon + " result:");
        try {
            System.out.println(calculateInfiniteSum(epsilon));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
