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
		this.category.add("����");
		this.category.add("����");
		this.category.add("����");
		this.category.add("�����");
		Item item = new Item("�����",1000,this.category.get(0));
		this.itemList.add(item);
		item = new Item("�ø��۽�",2500,this.category.get(0));
		this.itemList.add(item);
		item = new Item("����", 5000, category.get(1));
		this.itemList.add(item);
		item = new Item("��ġ", 4000, category.get(1));
		this.itemList.add(item);
		item = new Item("����", 5000, category.get(2));
		this.itemList.add(item);
		item = new Item("��ġ��", 12000, category.get(2));
		this.itemList.add(item);
		item = new Item("���̴�", 1000, category.get(3));
		this.itemList.add(item);
		item = new Item("�ݶ�", 1000, category.get(3));
		this.itemList.add(item);
		
	}
	public void printJang(User u) {
		for(int i=0; i<this.jangList.size(); i++) {
			if(u.getId().equals(this.jangList.get(i).getUserID())) {
				this.jangList.get(i).cartPrint();
			}
		}
	}
	
	public void printCate() {
		for(int i=0; i<this.category.size(); i++) {
			System.out.println(i+" : "+this.category.get(i));
		}
	}
	public void printItem() {
		for(int i=0; i<this.itemList.size(); i++) {
			this.itemList.get(i).itemPrint();
		}
	}
	public void itemPrint(int cateID) {
		int cnt = 0;
		for(int i=0; i<this.itemList.size(); i++) {
			if(this.category.get(cateID).equals(this.itemList.get(i).getCategory())) {
				System.out.print(cnt);
				System.out.println(" "+this.itemList.get(i).getName());
				cnt++;
			}
		}
	}
	public void addCart(String userID, int cartID, int itemID) {
		int cnt = 0;
		Cart temp = new Cart();
		for(int i=0; i<this.itemList.size(); i++) {
			if(this.category.get(cartID).equals(this.itemList.get(i).getCategory())) {
				if(cnt == itemID) {
					temp.setItemName(this.itemList.get(i).getName());
				}
				cnt++;
			}
		}
		temp.setUserID(userID);
		this.jangList.add(temp);
	}
	
}
