package models;

public class User {
	public String id;
	public int money;
	
	public User(String id, int mo){
		this.id = id;
		this.money = mo;
	}
	
	public void print() {
		System.out.println("["+id+"]"+ "ฑÝพื : "+money);
	}

	public String getId() {
		return this.id;
	}

	public int getMoney() {
		return this.money;
	}
}
