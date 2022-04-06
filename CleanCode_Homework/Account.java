package cts.hw1.initial;


public class Account {
	private double loanValue;
	private double rate;	
	private int daysActive;
	private int accountType;
	private static final int STANDARD=0,BUDGET=1,PREMIUM=2,SUPER_PREMIUM=3;
	
	public double loan() {
		System.out.println("The loan value is " + this.loanValue);
		return loanValue;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Loan: " + this.loanValue + 
				"; rate: " + this.rate + 
				"; days active:" + daysActive + 
				"; Type: " + accountType + ";";
	}

	public void print() {
		System.out.println("This is an account");
	}

	public static double calculate(Account[] accounts) {
		double totalFee = 0.0;
		double brokersFee = 0.0125;
		int days = 365;
		Account	account;
		for	(int i = 0; i < accounts.length; i++)	{
			account = accounts[i];
			if(account.accountType == Account.PREMIUM || account.accountType == Account.SUPER_PREMIUM) {
				//1.25%	broker's fee
				//interest-principal
				totalFee += brokersFee * 
							(account.loanValue * Math.pow(account.rate, (account.daysActive / days)) - account.loanValue);
			}
		}
		return	totalFee;
	}

	public Account(double value, double rate, int accountType) throws Exception {
		if(value < 0)
		{
			throw new Exception();
		}
		else 
		{
			loanValue = value;
		}
		this.rate = rate;
		this.accountType = accountType;
	}
	
}
