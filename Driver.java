public class Driver {
	
    // Constants representing various financial data
	final static int dayMultiplier = 1;
	final static double MONTHLY_ALLOWANCE = dayMultiplier* 348.0;      // Monthly income or allowance
	final static double AllocatedforWithdraw = dayMultiplier* 70;
	final static double PercentForSaving = 0.03;         // Percentage of allowance allocated for savings (10%)
	final static double PercentforEmergency = 0.15;      // Percentage of allowance allocated for emergencies (10%)
	final static double CarLoan = dayMultiplier* 100;                  // Fixed amount for car loan payment
	final static double FOOD = dayMultiplier* 28;                      // Fixed amount for food expenses
	final static double OilPricePerMonth = dayMultiplier* 50;          // Fixed amount for vehicle oil cost per month

	
	final static String type = "Allowance";

    // Method to calculate the amount allocated for savings
	public static double AllocateForSavings() {
		double savingsAllocated = 0;
		savingsAllocated += MONTHLY_ALLOWANCE * PercentForSaving;  // 10% of allowance for savings
		return savingsAllocated;
	}
	
	
    // Method to calculate the amount allocated for emergency
	public static double AllocateForEmergency() {
		double savingsAllocated = 0;
		savingsAllocated += MONTHLY_ALLOWANCE * PercentforEmergency;  // 10% of allowance for emergencies
		return savingsAllocated;
	}
	
    // Method to calculate the remaining amount after all allocations and expenses
	public static double AmountLeft() {
		double amount = 0;
		// Subtract savings, emergency, oil price, car loan, and food expenses from the total allowance
		amount += MONTHLY_ALLOWANCE - AllocateForEmergency() - AllocateForSavings() - OilPricePerMonth - CarLoan - FOOD;
		return amount;  // Return the remaining amount
	}
	
	public static double Withdraw() {
		double amount = 0;
		amount = AmountLeft() - AllocatedforWithdraw;
		return amount;
	}
	
    // Main method to execute the program
	public static void main(String[] args) {
		
		// Print the total monthly allowance
		System.out.println("Your monthly income is BND" + String.format("%.0f", MONTHLY_ALLOWANCE) + ".\n");
		System.out.println("day multiplifier = " + dayMultiplier);
		System.out.println("Percentage to savings: " + PercentForSaving);
		System.out.println("Percentage to emergency: " + PercentforEmergency);
		
		System.out.println();
		
		// Allocations section
		System.out.println("Allocations: " + "\n");
		
		// Print the savings amount and percentage
		System.out.println("Savings = BND" + String.format("%.0f", AllocateForSavings()));
		System.out.println("Allocation to in-hand: BND" + String.format("%.0f", AllocatedforWithdraw) + ".");
		// Print the emergency fund amount and percentage
		System.out.println("Emergency purposes = BND" + String.format("%.0f", AllocateForEmergency()));
		
		// Spending section
		System.out.println("\n" + "Spendings: " + "\n");
		
		// Print car loan expense
		System.out.println("Vehicle loan (per month)  = BND" + String.format("%.0f", CarLoan));
		
		// Print food expense
		System.out.println("Expected Food (per month)= BND" + String.format("%.0f", FOOD));
		
		// Print oil price expense
		System.out.println("Expected Vehicle oil (per month) = BND" + String.format("%.0f", OilPricePerMonth) + "\n");
		
		// Print the final result: amount left after all spending
		System.out.println("Result: " + "\n");
		System.out.println("Amount left in bank = BND" + String.format("%.0f", Withdraw()) + " (" + type + " - spendings - allocated in-hand)" );
		
		System.out.println("Amount in hand = BND" + String.format("%.0f", AllocatedforWithdraw));
		
		System.out.println("Emergency funds in-hand = BND" + String.format("%.0f", AllocateForEmergency()));
	}
}
