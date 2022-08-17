
public class BankAccount {

	private double balance;
	private double minimunBalance;
	private boolean isActive = true;
	private String holderName;

	public BankAccount(double balance, double minimunBalance) {
		this.balance = balance;
		this.minimunBalance = minimunBalance;
	}

	public double getBalance() {
		return balance;
	}

	public double getMinimunBalance() {
		return minimunBalance;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public double withdraw(double amount) {
		if (balance - amount > minimunBalance) {
			balance -= amount;
			return amount;
		} else {
			throw new RuntimeException();
		}
	}
	
	public double deposit(double amount) {
		return balance += amount;
	}
	

}
