import java.sql.SQLOutput;
//imports are added
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TipCalculator {
    public static void main(String[] args) {
        // asks for the information needed for the computer by the user.
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Tip Calculator! ");

        System.out.print("How many people are in your group: ");
        int people = scan.nextInt();

        System.out.print("What is your tip percentage? (0-100) ");
        int percent = scan.nextInt();

        // initializes values
        double cost = 0;
        double total = 0;
        double rate = 0;
        double rating = 0;
        //creates list for menu
        List<String> menu = new ArrayList<>();

        // repeats until user want to end
        while (cost != -1) {
            total += cost;
            rating += rate;
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
            cost = scan.nextDouble();
            scan.nextLine();
            if (cost != -1) {
                System.out.print("Enter the item: ");
                String item = scan.nextLine();
                menu.add(item);
                System.out.print("What would you rate this item out of 5: ");
                rate = scan.nextDouble();
                scan.nextLine();
            }
        }
        // This will be used to ise Math.round
        double scale = Math.pow(10, 2);
        // prints the total and percentage
        System.out.println("---------------------------------");
        total = Math.round(total * scale) / scale;
        System.out.println("Total before tip: $" + total );
        System.out.println("Total percentage: " + percent + "%");

        // calculates and prints tip
        double tip = total * ((double)percent / 100.0);
        double RealTip = Math.round(tip * scale) / scale;
        System.out.println("Total Tip: $" + ((RealTip)));

        // prints total with tip
        double AbsoluteTotal = Math.round((total + RealTip) * scale) / scale;
        System.out.println("Total bill with tip: $" + AbsoluteTotal);

        //calculates the total split before tip
        double SplitTotal = total / people;
        double rSplitTotal = Math.round(SplitTotal * scale) / scale;
        System.out.println("Per person cost before tip: $" + rSplitTotal);

        //determines the total tip each person is paying
        double SplitTip = RealTip / people;
        double rSplitTip = Math.round(SplitTip * scale) / scale;
        System.out.println("Total Tip per person: $" + rSplitTip);

        //determines total cost per person
        double SplitWithTip = rSplitTotal + rSplitTip;
        SplitWithTip = Math.round(SplitWithTip * scale) / scale;
        System.out.println("Total cost per person: $" + SplitWithTip);

        System.out.println("---------------------------------");
        System.out.println("Items ordered: ");

        // prints out the menu
        int value = 0;
        while (value != menu.size()) {
            String index = menu.get(value);
            System.out.println(index);
            value = value + 1;
            }
        //prints out the final rating
        System.out.println("---------------------------------");
        System.out.println("Overall you gave this restaurant: " + (rating/menu.size()) + "* out of 5*.");
        System.out.println("---------------------------------");
        }
    }

