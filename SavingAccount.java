package bankApplication;

public class SavingAccount extends Account{
	

	// List properties specific to savings account
	
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	// Constructor to initialize settings for the savings account
	
	public SavingAccount(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "1" + accountNumber;
		
		// Generate safetyDepositBoxID
		
		setSafetyDepositBox();
		
	}
	// List any methods specific to savings account
	
	@Override
	public void setRate() {
		rate = getBaseRate() - .25;
		
	}
	
	@Override
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: SAVINGS");
		super.showInfo();
		System.out.println("SAFETY DEPOSIT BOX ID: " + safetyDepositBoxID);
		System.out.println("SAFETY DEPOSIT BOX KEY: " + safetyDepositBoxKey);
	}
	
	private void setSafetyDepositBox() {
		
		safetyDepositBoxID = (int)(Math.random() * Math.pow(10, 3));
		
		
		safetyDepositBoxKey = (int)(Math.random() * Math.pow(10, 4));
		
	}

	
	
	
}
