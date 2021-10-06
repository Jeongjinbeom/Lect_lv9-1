package controller;

import java.util.Scanner;
import java.util.Vector;

import models.Cart;
import models.Item;
import models.User;

public class ItemManager {
	Vector<Item> itemList = new Vector<Item>();
	Vector<Cart> jangList = new Vector<Cart>();
	Vector<String> category = new Vector<String>();
	Scanner scan = new Scanner(System.in);
	
	public ItemManager(){
		inti();
	}
	
	void inti() {
		category.add("과자");
		category.add("생선");
		category.add("육류");
		category.add("음료수");
		Item temp = new Item("새우깡", 1000, category.get(0));
		itemList.add(temp);
		temp = new Item("고등어", 2000, category.get(1));
		itemList.add(temp);
		temp = new Item("칸쵸", 3600, category.get(0));
		itemList.add(temp);
		temp = new Item("소고기", 6500, category.get(2));
		itemList.add(temp);
		temp = new Item("콜라", 500, category.get(3));
		itemList.add(temp);
		temp = new Item("새우", 1800, category.get(1));
		itemList.add(temp);
	}
	
	public void printJang(User u) {
		for(int i=0; i<jangList.size(); i++) {
			if(u.id.equals(jangList.get(i).UserID)) {
				jangList.get(i).print();
			}
		}
	}
	
	public void printCategory() {
		for(int i=0; i<category.size(); i++) {
			System.out.println("["+i+"]"+category.get(i));
		}
	}
	
	public void printItem() {
		for(int i=0; i<itemList.size(); i++) {
			itemList.get(i).print();
		}
	}
	
	public void printItem(int caID) {
		int n = 0;
		for(int i=0; i<itemList.size(); i++) {
			if(category.get(caID).equals(itemList.get(i).category)) {
				System.out.print("["+n+"]");
				System.out.println(itemList.get(i).name);
				n += 1;
			}
		}
	}
	
	public void addItem() {
		System.out.println("아이템 이름을 입력하세요.");
		String name = scan.next();
		System.out.println("아이템 가격을 입력하세요.");
		int price = scan.nextInt();
		printCategory();
		System.out.println("카테고리 번호를 입력하세요.");
		int caID = scan.nextInt();
		Item temp = new Item(name, price, category.get(caID));
		itemList.add(temp);
	}
	public void removeItem() {
		int check = -1;
		printItem();
		System.out.println("아이템 이름을 입력하세요.");
		String name = scan.next();
		for(int i=0; i<itemList.size(); i++) {
			if(itemList.get(i).name.equals(name)) {
				check = i;
			}
		}
		if(check == -1) {
			System.out.println("존재하지않는 아이템입니다.");
			return;
		}
		else {
			itemList.remove(check);
			System.out.println("삭제가 완료되었습니다.");
		}
	}
	
	public void addCategory() {
		System.out.println("카테고리 이름을 입력하세요.");
		String name = scan.next();
		category.add(name);
	}
	
	public void removeCategory() {
		printCategory();
		System.out.println("번호를 입력하세요.");
		int index = scan.nextInt();
		for(int i=0; i<itemList.size(); i++) {
			if(category.get(index).equals(itemList.get(i).category)) {
				itemList.remove(i);
			}
			
		}
		category.remove(index);
	}
	
	public void addCart(String usID, int caID, int itemID) {
		int n = 0;
		Cart temp = new Cart();
		for(int i=0; i<itemList.size(); i++) {
			if(category.get(caID).equals(itemList.get(i).category)) {
				if(n == itemID) {
					temp.ItemName = itemList.get(i).name;
				}
				n += 1;
			}
		}
		temp.UserID = usID;
		jangList.add(temp);
	}
	
	public void removeCart(User u) {
		System.out.println("삭제할 아이템을 입력해주세요.");
		String name = scan.next();
		
		int check = -1;
		for(int i=0; i<jangList.size(); i++) {
			if(jangList.get(i).UserID.equals(u.id) && jangList.get(i).ItemName.equals(name)) {
				check = i;
			}
		}
		if(check == -1) {
			System.out.println("존재하지않는 아이템입니다.");
		}
		else {
			System.out.println("삭제되었습니다.");
			jangList.remove(check);
		}
	}
	
	public void buyItem(User u) {
		int money = 0;
		for(int i=0; i<jangList.size(); i++) {
			String name;
			if(jangList.get(i).UserID.equals(u.id)) {
				name = jangList.get(i).ItemName;
				for(int j=0; j<itemList.size(); j++) {
					if(itemList.get(j).name.equals(name)) {
						money += itemList.get(j).price;
					}
				}
			}
		}
		System.out.println("총 가격 : "+ money+", 구매하시겠습니까?1)예 2)아니오");
		int sel = scan.nextInt();
		
		if(sel==1) {
			u.money -= money;
			System.out.println("구매 완료되었습니다.");
		}
		else if(sel==2) {
			return;
		}
	}
}
