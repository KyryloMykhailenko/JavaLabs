package lab3;

public class Test {
    public static void main(String[] args) {
        double degrees = 30.0;
        // Перетворення градусів у радіани
        // double radians = Math.toRadians(degrees);
        double radians = degrees*Math.PI/180;

        double sinValue = Math.sin(radians); // Обчислення синуса
        System.out.println("Синус кута 30 градусів: " + sinValue);
    }
}

