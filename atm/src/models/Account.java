package models;

public class Account {
public static final int MAX = 3;
	
	private int accNum;
	private int money;
	private int userCode;
	
	
	public Account(int userCode, int accNum) {
		this.userCode = userCode;
		this.accNum = accNum;
		this.money = 1000;
	}
	public Account(int userCode, int accNum, int money) {
		this.userCode = userCode;
		this.accNum = accNum;
		this.money = money;
	}
	
	//getter
	public int getUserCode() {
		return this.userCode;
	}
	
	public int getAccNum() {
		return this.accNum;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	//setter
	public void setMoney(int money) {
		this.money = money;
	}
	
	public String toString() {
		return this.accNum + " : " + this.money;
	}
	
}
