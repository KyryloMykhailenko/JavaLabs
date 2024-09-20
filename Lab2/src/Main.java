//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // Завдання 4
    public static double task4(double a, double b, double c, double d) {
        return Math.sqrt(Math.tan(a)) / (1 + Math.sinh(b) / (Math.log(d) + c));
    }

    // Завдання 14
    public static double task14(double a, double b, double c, double d) {
        return 2 * Math.sqrt(Math.sin(a) / Math.tan(b - a) + Math.log(c) / d);
    }

    // Завдання 24
    public static double task24(double a, double b, double c, double d) {
        return (Math.cos(b) + Math.sin(Math.sqrt(a))) / (2 * Math.log10(c) + Math.exp(d));
    }

    public static void main(String[] args) {
        // Вхідні дані з таблиці
        // Для завдання 4
        double a1 = 3.56, b1 = 1.02, c1 = 3, d1 = 2.43;
        double result4 = task4(a1, b1, c1, d1);
        System.out.println("Результат завдання 4: " + result4);

        // Для завдання 14
        double a2 = 1.54, b2 = 0.49, c2 = 24.1, d2 = 0.87;
        double result14 = task14(a2, b2, c2, d2);
        System.out.println("Результат завдання 14: " + result14);

        // Для завдання 24
        double a3 = 0.345, b3 = -2.25, c3 = 2.65, d3 = 3.99;
        double result24 = task24(a3, b3, c3, d3);
        System.out.println("Результат завдання 24: " + result24);
    }
}
