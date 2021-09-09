//Reymond Ramirez 05/12/2021 project 5
public class Account {
	
	private String Name;
	private String accountNum;
	private String pass;
	private double bal;
	
	public Account(String name, String accountNumber, String password, double balance) {
		Name = name;
		accountNum = accountNumber;
		pass = password;
		bal = balance;
	}

	public boolean isMatchingAccount(String accountNumber,String password) {
		// if the account number and password match return true else return false
		if (accountNumber.equals(accountNum) && password.equals(pass)) {
			return true;
		}else {
			return false;
		}
	}

	public void deposit(double amount) {
		if (amount > 0) {
			bal = bal + amount;
		}
		//returns nothing
		//adds amount to existing value
	}

	public boolean withdrawal(double amount) {
		double tempAmount = 0;
		tempAmount = bal - amount;
		if (tempAmount >= 0) {
			bal = bal - amount;
			return true;
		}else {
			//returns true if you have enough funds to withdraw returns false if funds will be less then 0
			//deducts amount from balance\
			//returns true because i am assuming it confirms the withdraw
			return false;
		}
	}


	public double getBalance() {
		// returns the balance of this account
		return bal;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getAcc() {
		return accountNum;
	}
}
