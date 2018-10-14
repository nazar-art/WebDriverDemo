package zDemo;

import java.util.Scanner;

public class CircleApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String calcAgain;

        do {
            System.out.print("Enter a radius: ");
            double radius = sc.nextDouble();

            //Diameter=2 * radius
            double diameter = 2 * radius;
            System.out.println("Diameter: " + diameter);

            //Circumference= 2 * PI * radius
            double circumference = Math.PI * 2 * radius;
            System.out.println("Circumference: " + circumference);

            //Area= PI*radius*radius
            double area = Math.PI * (radius * radius);
            System.out.println("Area: " + area);


            //Would the user like to calculate again?
            System.out.print("Would you like to enter another circle? (Y/N): ");
            calcAgain = sc.next();

        } while (calcAgain.equalsIgnoreCase("Y"));
    }
}
