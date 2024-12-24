package lab6;

public class Main {

    // Метод для конвертації числа в двійкову систему
    public static String intToBinaryString(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Число має бути невід'ємним.");
        }
        return Integer.toBinaryString(i);
    }

    // Метод для перетворення всіх слів у верхній регістр
    public static String toUpperCaseWords(String input) {
        if (input == null) {
            throw new NullPointerException("Рядок не може бути null.");
        }
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Рядок не може бути порожнім або містити лише пробіли.");
        }
        // Перетворення слів (складаються з літер a-z, A-Z) у верхній регістр
        String[] words = input.split("\\b");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.matches("[a-zA-Z]+")) {
                result.append(word.toUpperCase());
            } else {
                result.append(word);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Завдання №2: Конвертація числа в двійкову систему числення
        System.out.println("Завдання №2: Перетворення числа у двійкову систему");
        try {
            System.out.println("21 -> " + intToBinaryString(21)); // Очікуваний результат: "10101"
            System.out.println("0 -> " + intToBinaryString(0));  // Очікуваний результат: "0"
            System.out.println("255 -> " + intToBinaryString(255)); // Очікуваний результат: "11111111"
            System.out.println("-5 -> " + intToBinaryString(-5)); // Очікує викидання виключення
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // Завдання №10: Перетворення слів у верхній регістр
        System.out.println("\nЗавдання №10: Перетворення слів у верхній регістр");
        try {
            String input1 = "The user with the nickname koala757677 this month wrote 3 times more comments";
            String input2 = "123 hello world!";
            System.out.println("Input 1: " + input1);
            System.out.println("Result: " + toUpperCaseWords(input1));
            System.out.println("Input 2: " + input2);
            System.out.println("Result: " + toUpperCaseWords(input2));

            // Некоректне значення (null)
            System.out.println(toUpperCaseWords(null)); // Очікує викидання виключення
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
