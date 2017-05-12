package banking.interfaces;

import javax.swing.JOptionPane;

import primitive.core.DepositParameter;

@SuppressWarnings("serial")
public abstract class AAccount implements IAsset {
	protected float accountBalance = 0.0F; //CST316 ACTIVITY 1.4
	protected String name;

	public AAccount(String n) {
		name = n;
	}

	public AAccount(String n, float b) {
		name = n;
		accountBalance = b;  //CST316 ACTIVITY 1.4
	}

	public void display() {
		JOptionPane.showMessageDialog(null, "Account " + name + " has $" + accountBalance);
		//CST316 ACTIVITY 1.4
	}

	public String getName() {
		return name;
	}

	public float getBalance() {
		return accountBalance;  //CST316 ACTIVITY 1.4
	}

	public abstract void deposit(DepositParameter parameterObject);

	public abstract void withdraw(float amount);

	public String toString() {
		return "Account " + name + " has $" + accountBalance + "\n";  //CST316 ACTIVITY 1.4
	}
}