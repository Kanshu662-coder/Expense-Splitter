import java.util.Scanner;


public class ExpenseSplitter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        double[] spent = new double[n];

        double totalExpense = 0;

        // Input names and expenses
        for (int i = 0; i < n; i++) {

            System.out.print("\nEnter name of person " + (i + 1) + ": ");
            names[i] = sc.next();

            System.out.print("Enter amount spent by " + names[i] + ": ");
            spent[i] = sc.nextDouble();

            totalExpense += spent[i];
        }
        // Calculate equal share
        double share = totalExpense / n;

        System.out.println("\n========= Expense Summary =========");
        System.out.println("Total Expense: " + totalExpense);
        System.out.println("Each Person Should Pay: " + share);

        // Calculate who pays whom
        System.out.println("\n========= Settlement =========");

        for (int i = 0; i < n; i++) {

            double balance = spent[i] - share;

            if (balance > 0) {
                System.out.println(names[i] + " should receive ₹" 
                                   + String.format("%.2f", balance));
            } 
            else if (balance < 0) {
                System.out.println(names[i] + " should pay ₹" 
                                   + String.format("%.2f", Math.abs(balance)));
            } 
            else {
                System.out.println(names[i] + " is settled.");
            }
        }
        sc.close();
    }
}