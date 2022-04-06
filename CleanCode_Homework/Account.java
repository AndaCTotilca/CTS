package cts.hw1.initial;


public class Account {
	public double loanValue;
	public double rate;	
	public int daysActive;
	public int accountType;
	public static final int	STANDARD=0,BUDGET=1,PREMIUM=2,SUPER_PREMIUM=3;
	
	public double loan() {
		System.out.println("The loan value is " + this.loanValue);
		return loanValue;
	}
	
	public double getRate() {
		System.out.println("The rate is " + rate);
		return this.rate;
	}
	
	//must have method - the lead has requested it in all classes
	public double getMonthlyRate() {
		return loanValue * rate;
	}
	
	public void setValue(double value) throws Exception {
		if(value < 0)
			throw new Exception();
		else {
			loanValue = value;
		}
	}
	
	public String to_string() {
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
			if(account.accountType == Account.PREMIUM || account.accountType == Account.SUPER_PREMIUM)	
				//1.25%	broker's fee
				//interest-principal
				totalFee += brokersFee * 
							(account.loanValue * Math.pow(account.rate, (account.daysActive / days)) - account.loanValue);	
		}
		return	totalFee;
	}

	public Account(double value, double rate, int accountType) throws Exception {
		if(value<0)
			throw new Exception();
		else 
		{
			loanValue = value;
		}
		this.rate = rate;
		this.accountType = accountType;
	}
	
}
