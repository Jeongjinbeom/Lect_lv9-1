package controller;

import java.util.Scanner;
import java.util.Vector;

import models.Cart;
import models.Item;
import models.User;

public class ItemManager {
	private Vector<Item> itemList = new Vector<Item>();
	private Vector<Cart> jangList = new Vector<Cart>();
	private Vector<String> category = new Vector<String>();
	Scanner scan = new Scanner(System.in);

	public ItemManager() {
		itemMenu();
	}

	private void itemMenu() {
		this.category.add("과자");
		this.category.add("생선");
		this.category.add("육류");
		this.category.add("음료수");
		Item item = new Item("새우깡", 1000, this.category.get(0));
		this.itemList.add(item);
		item = new Item("플링글스", 2500, this.category.get(0));
		this.itemList.add(item);
		item = new Item("조기", 5000, category.get(1));
		this.itemList.add(item);
		item = new Item("삼치", 4000, category.get(1));
		this.itemList.add(item);
		item = new Item("삼겹살", 5000, category.get(2));
		this.itemList.add(item);
		item = new Item("살치살", 12000, category.get(2));
		this.itemList.add(item);
		item = new Item("사이다", 1000, category.get(3));
		this.itemList.add(item);
		item = new Item("콜라", 1000, category.get(3));
		this.itemList.add(item);

	}

	public void printJang(User u) {
		for (int i = 0; i < this.jangList.size(); i++) {
			if (u.getId().equals(this.jangList.get(i).getUserID())) {
				this.jangList.get(i).cartPrint();
			}
		}
	}

	public void printCate() {
		for (int i = 0; i < this.category.size(); i++) {
			System.out.println(i + " : " + this.category.get(i));
		}
	}

	public void printItem() {
		for (int i = 0; i < this.itemList.size(); i++) {
			this.itemList.get(i).itemPrint();
		}
	}

	public void itemPrint(int cateID) {
		int cnt = 0;
		for (int i = 0; i < this.itemList.size(); i++) {
			if (this.category.get(cateID).equals(this.itemList.get(i).getCategory())) {
				System.out.print(cnt);
				System.out.println(" " + this.itemList.get(i).getName());
				cnt++;
			}
		}
	}

	public void addCart(String userID, int cartID, int itemID) {
		int cnt = 0;
		Cart temp = new Cart();
		for (int i = 0; i < this.itemList.size(); i++) {
			if (this.category.get(cartID).equals(this.itemList.get(i).getCategory())) {
				if (cnt == itemID) {
					temp.setItemName(this.itemList.get(i).getName());
				}
				cnt++;
			}
		}
		temp.setUserID(userID);
		this.jangList.add(temp);
	}

	public void removeCart(User u) {
		System.out.println("삭제할 아이템 입력 : ");
		String name = scan.next();
		int ch = -1;
		for (int i = 0; i < this.jangList.size(); i++) {
			if (this.jangList.get(i).getUserID().equals(u.getId()) && this.jangList.get(i).getItemName().equals(name)) {
				ch = i;
			}
		}
		if (ch == -1) {
			System.out.println("존재하지 않는 아이템입니다.");
		} else {
			System.out.println("삭제가 완료 되었습니다.");
			this.jangList.remove(ch);
		}
	}

	public void getItem(User u) {
		int money = 0;
		for (int i = 0; i < this.jangList.size(); i++) {
			String name;
			if (this.jangList.get(i).getUserID().equals(u.getId())) {
				name = this.jangList.get(i).getItemName();
				for (int j = 0; j < this.itemList.size(); j++) {
					if (this.itemList.get(j).getName().equals(name)) {
						money += this.itemList.get(j).getPrice();
					}
				}
			}
		}
		System.out.println("총 금액 " + money + "원 입니다 구매하시겠습니까 ? 1)예 2)아니오");
		int sel = scan.nextInt();
		if (sel == 1) {
			u.setMoney(u.getMoney() - money);
			System.out.println("구매완료");
		} else if (sel == 2) {
			return;
		} else {
			System.out.println("잘못된 매뉴선택입니다.");
		}
	}

	public void addItem() {
		System.out.println("아이템 이름 입력 : ");
		String name = scan.next();
		System.out.println("아이템 가격 입력 : ");
		int price = scan.nextInt();
		printCate();
		System.out.println("카테고리 번호 입력 : ");
		int category = scan.nextInt();
		Item temp = new Item(name, price, this.category.get(category));
		this.itemList.add(temp);
	}

	public void removeItem() {
		int ch = -1;
		printItem();
		System.out.println("삭제할 아이템 입력 : ");
		String name = scan.next();
		for (int i = 0; i < this.itemList.size(); i++) {
			if (this.itemList.get(i).getName().equals(name)) {
				ch = i;
			}
		}
		if (ch == -1) {
			System.out.println("존재하지않는 아이템입니다.");
		} else {
			this.itemList.remove(ch);
			System.out.println("삭제가 완료되었습니다.");
		}
	}

	public void addCategory() {
		System.out.println("카테고리 입력 : ");
		String name = scan.next();
		this.category.add(name);
	}

	public void removeCategory() {
		printCate();
		System.out.println("번호를 입력 : ");
		int index = scan.nextInt();
		for (int i = 0; i < this.itemList.size(); i++) {
			if (this.category.get(index).equals(itemList.get(i).getCategory())) {
				this.itemList.remove(i);
			}

		}
		this.category.remove(index);
	}

}
