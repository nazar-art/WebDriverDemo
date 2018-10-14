package zDemo;

import java.util.Formatter;

public class Celsius {
    public static void main(String[] args) {
//        oldVersion();
//        System.out.println();
        updatedVersion();
    }

    private static void updatedVersion() {
        Formatter formatter = new Formatter(System.out);

        formatter.format("%-20s\n",      "---------------------------");
        formatter.format("%-10s %12s\n", "| Fahrenheit |", "demo.Celsius |");
        formatter.format("%-20s\n",      "---------------------------");

        for (int farValue = -45; farValue <= 80; farValue += 5) {
            double celValue = (farValue + (9.0 / 5.0)) * 32;
            formatter.format("| %10d | %10.0f |\n", farValue, celValue);
        }
        formatter.format("%-20s\n",      "---------------------------");
    }

    private static void oldVersion() {
        System.out.println("Fahrenheit\tdemo.Celsius");
        System.out.println("=======================");
        for (int temp = -45; temp <= 120; temp += 5) {
            System.out.printf("%5d       |", temp);
            double sum = (temp + (9.0 / 5.0)) * 32;
            System.out.printf("%5d", (int) sum);
            System.out.println();
        }
    }
}
