import java.util.Scanner;
public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Tip Calculator! ");

        System.out.print("How may people are in your group: ");
        int people = scan.nextInt();

        System.out.print("What is your tip percentage? (0-100) ");
        int percent = scan.nextInt();

        double cost = 0;
        double total = 0;
        while (cost != -1) {
            total += cost;
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
            cost = scan.nextDouble();
        }
        System.out.println("---------------------------------");
        System.out.println("Total before tip: $" + total );
        System.out.println("Total percentage: " + percent + "%");
        double tip = total * ((double)percent / 100);
        tip /= 1.00;
        System.out.println("Total Tip: $" + tip);
    }
}
