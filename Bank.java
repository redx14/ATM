//Reymond Ramirez 05/12/2021 project 5

import java.util.Scanner;
public class Bank {
	final static int DISPLAY_BALANCE = 1;
	final static int DEPOSIT = DISPLAY_BALANCE + 1;
	final static int WITHDRAWAL = DEPOSIT + 1;
	final static int LOGOUT = WITHDRAWAL + 1;
	public static String accIn;
	public static String accPass;
	public static double amount;
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean bank = true;
		int index;
		int choice;
     	Account[] accounts = {
     			new Account("Tom", "45678-1", "password", 100.),
     			new Account("Dick", "12345-9", "123", 75.),
     			new Account("Harry", "54321-0", "myname", 1000.),
     			new Account("DB Cooper", "54321-1", "harry", 250000.)
     			};
     	while(true) {
	     	System.out.print("Enter Your Account Number: ");
	     	accIn = keyboard.next();
	     	System.out.print("Password: ");
	     	accPass = keyboard.next();
			
	     	while(findAccount(accounts, accIn, accPass) == -1) {
	     		System.out.println("Invalid Account or Password");
	     		System.out.println("");
		     	System.out.print("Enter Your Account Number: ");
		     	accIn = keyboard.next();
		     	System.out.print("Password: ");
		     	accPass = keyboard.next();
	     	}
	     	index = findAccount(accounts, accIn, accPass);
	     	System.out.println("Choose from the following options:");
			System.out.println("1. Display Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Log Out");
	     	bank = true;
	     	while (bank == true) {
	     		choice = menu();
		     	switch(choice) {
				case DISPLAY_BALANCE:
					System.out.println(accounts[index].getName() + "'s Account: " + accounts[index].getAcc());
					System.out.println("Balance is $" + accounts[index].getBalance());
					System.out.println("");
					break;
				case DEPOSIT:
					System.out.print("Amount to deposit: ");
					amount = keyboard.nextDouble();
					if(amount < 1) {
						System.out.println("Invalid amount!");
						break;
					}
					accounts[index].deposit(amount);
					System.out.println("New Balance: $" + accounts[index].getBalance());
					System.out.println("");
					break;
				case WITHDRAWAL:
					System.out.print("Amount to withdraw: ");
					amount = keyboard.nextDouble();
					if(amount < 1) {
						System.out.println("Invalid amount!");
						break;
					}
					if (accounts[index].withdrawal(amount) == true) {
						System.out.println("New Balance: $" + accounts[index].getBalance());
						System.out.println("");
					}else {
						System.out.println("*** Insuficient funds ***");
					}
					break;
				case LOGOUT:
					System.out.println("Have a Nice Day!");
					bank = false;
					System.out.println("");
					break;
				}
	     	}
     	}
	}

	private static int menu() {
		// Code to return the selected option 1 to 4. Print error
    	// is not a valid selection
		int menuChoice = 0;
		
		do {
			System.out.print("Option: ");
			menuChoice = keyboard.nextInt();
			System.out.println("");
			
			switch(menuChoice) {
			case 1:
				//System.out.println("option 1 was entered and break");
				return menuChoice;
			case 2:
				//System.out.println("option 2 was entered and break");
				return menuChoice;
			case 3:
				//System.out.println("option 3 was entered and break");
				return menuChoice;
			case 4:
				//System.out.println("option 4 was entered and break");
				return menuChoice;
			default:
				System.out.println("Invalid Option!");
			}
		}while(menuChoice != 4);
		
    	return menuChoice;
	}

	private static int findAccount(Account[] accounts,String accountNumber, String password) {
		// Code to return the index in the accounts array where the
    	// account number and password match.
    	// Return -1 if account is not found or password is not a valid
		for(int i = 0; i < accounts.length; i++) {
			if(accounts[i].isMatchingAccount(accIn, accPass) == true) {
				//System.out.println("Account matched");
				return i;
			}
		}
    	return -1;
	}

}
