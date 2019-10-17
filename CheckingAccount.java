package bankApplication;

public class CheckingAccount extends Account {
	
	// List properties that are specific to checking account
	private long debitCardNumber;
	private int debitCardPin;
	
	// Constructor to initialize constructor properties
	//The first digit of accountNumber will be concatenated to the account # created in the parent constructor
	
	public CheckingAccount(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
		
		
	}
	
	
	// List any methods specifically made for this class
	
	@Override
	public void setRate() {
		rate = getBaseRate() * .15;
	}

	@Override
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: CHECKING");
		super.showInfo();
		System.out.println("DEBIT CARD NUMBER: " + debitCardNumber);
		System.out.println("DEBIT CARD PIN: " + debitCardPin);
	}
	
	private void setDebitCard() {
		debitCardNumber = (long)(Math.random() * Math.pow(10, 12));
		debitCardPin = (int)(Math.random() * Math.pow(10, 4));
	}
}
