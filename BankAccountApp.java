package bankApplication;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		
		// file to be read
		
		String file = "/Users/macbook/Downloads/NewBankAccounts (1).csv";
		
		// data Structure to store accounts
		List<Account> accounts = new LinkedList<Account>();
		
		// Read a CSV file then create new accounts based on that data
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for (String[] accountHolder : newAccountHolders) {
			
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			
		//store each element based on the account type
			
			if (accountType.equals("Savings")) {
				
				accounts.add(new SavingAccount(name, sSN, initDeposit));
				
			} else if(accountType.equals("Checking")) {
				
				accounts.add(new CheckingAccount(name, sSN, initDeposit));
				
			} else {
				
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		
		//display info of each account after creating new accounts
		
		for (Account acc: accounts) {
			
			System.out.println("\n**********");
			acc.showInfo();
		}
	}

}
