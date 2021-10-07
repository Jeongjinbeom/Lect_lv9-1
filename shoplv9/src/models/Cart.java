package models;

public class Cart {
	private String UserID;
	private String ItemName;
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public void cartPrint() {
		System.out.println("["+UserID+"] :"+ItemName);
	}
}
