package models;

public class Bank {
	public static Bank instance = new Bank(); 
	private String brand = "";
	//ㄴ Bank 인스턴스(객체)가 시스템 실행 시, 유일하게 존재하도록 만들어줌
	public static int log = -1;
	
	
	public String getBrand() {
		return this.brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}
