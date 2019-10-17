package bankApplication;
//this is abstract b/c we will not be creating obj from this class, but child classes will



public abstract class Account implements IBaseRate {

	// List common properties for checking and saving accounts
	
	private String name;
	private String sSN;
	protected String accountNumber;
	protected double rate;
	private double balance;
	private static int index = 100000;
	
	
	
	
	// Constructor to set base properties and initialize account
	
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		this.balance = initDeposit;
		
		// Set Account Number
		
		this.accountNumber = setAccountNumber();
		setRate();
		
		
	}
	
	public abstract void setRate();
	
	
	private String setAccountNumber() {
		index++;
		int uniqueID = index;
		String lastTwoOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
		int randomNumber = (int)(Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
		
	}
	
	public void compound() {
		double accruedInterest = balance * (rate / 100);
		balance += accruedInterest;
		System.out.println("ACCRUED INTEREST $" + accruedInterest);
		printBalance();
	}
	
	
	public void deposit(double amount) {
		balance += amount;
		System.out.println("$" + amount + " has been deposited into account");
		printBalance();
		
	}
	
	public void withdraw(double withdrawalAmount) {
		
		if (balance >= withdrawalAmount) {
			balance -= withdrawalAmount;
			System.out.println("$" + withdrawalAmount + " has been withdrawn from account");
			printBalance();
		} else {
			System.out.println("Insufficient Funds");
		}
	}
	
	public void transfer(Account sendingTo, double transferAmount) {
		
		this.withdraw(transferAmount);
		sendingTo.deposit(transferAmount);
		System.out.println(this.name + " has successfully transferred $" + transferAmount + " to " + sendingTo.name);
		
	}
	
	public void printBalance() {
		System.out.println(this.name + "'s balance is " + balance);
		
	}
	
	public void showInfo() {
		System.out.println(
				"NAME: " + name +
				"\nACCOUNT NUMBER: " + accountNumber +
				"\nBALANCE: $" + balance +
				"\nRATE: " + rate + "%");
	}
	
	
}
