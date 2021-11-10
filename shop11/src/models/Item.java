package models;

public class Item {
	private String name;
	private int price;
	private String category;

	public Item(String name, int price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public void itemPrint() {
		System.out.println("[" + name + "]" + "[" + price + "]" + "[" + getCategory() + "]");
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
