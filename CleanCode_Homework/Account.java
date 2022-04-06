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
	
	
	public double getLoanValue() {
		return loanValue;
	}


	public void setLoanValue(double loanValue) {
		this.loanValue = loanValue;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	public int getDaysActive() {
		return daysActive;
	}


	public void setDaysActive(int daysActive) {
		this.daysActive = daysActive;
	}


	public int getAccountType() {
		return accountType;
	}


	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}


	@Override
	public String toString() {
		return "Loan: " + this.getLoanValue() + 
				"; rate: " + this.getRate() + 
				"; days active:" + this.getDaysActive() + 
				"; Type: " + this.getAccountType() + ";";
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
				totalFee += brokersFee * 
							(account.getLoanValue() * Math.pow(account.getRate(), (account.getDaysActive() / days)) - account.getLoanValue());
			}
		}
		return totalFee;
	}

	public Account(double value, double rate, int accountType) throws Exception {
		if(value < 0)
		{
			throw new Exception();
		}
		else 
		{
			this.setLoanValue(value);
		}
		this.setRate(rate);
		this.setAccountType(accountType);
	}
	
}
