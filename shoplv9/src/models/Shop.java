package models;

import java.util.Scanner;

import controller.ItemManager;
import controller.UserManager;

public class Shop {
	Scanner sc = new Scanner(System.in);
	public static Shop instance = new Shop();
	
	UserManager um = new UserManager();
	ItemManager im = new ItemManager();
	public void run() {
		mainRun();
	}
	
	public void mainRun() {
		while(true) {
			um.print();
			System.out.println();
			System.out.println("=======SuperMaket======");
			System.out.println(" 1)����\n 2)Ż��\n 3)�α���\n 4)�α׾ƿ�\n 100)�����ڸ��\n 0)����");
			System.out.println("�Ŵ����� : ");
			int sel = sc.nextInt();
			if(sel == 1) {
				um.join();
			}else if(sel == 2) {
				um.remove();
			}else if(sel == 3) {
				if(um.login()) {
					loginRun();
				}
			}else if(sel == 4) {
				um.logout();
			}else if(sel == 100) {
				
			}else if(sel == 0) {
				break;
			}else {
				System.out.println("�߸��� �Ŵ������Դϴ�.");
			}
		
		}
	}
	
	public void loginRun() {
		while (true) {
			System.out.println(" 1.����\n2.��ٱ��ϸ��\n0.�ڷΰ���\n");
			int sel = sc.nextInt();
			if (sel == 1) {
				shopMenu();
			} else if (sel == 2) {
				cartMenu();
			} else if (sel == 0) {
				break;
			}
		}
	}

	private void cartMenu() {
		
	}

	private void shopMenu() {
		while(true) {
			String id = um.userList.get(um.getUserLog()).getId();
			System.out.println("�Ŵ� ���� : " +"���� : -1");
			im.printCate();
			int cateID = sc.nextInt();
			if(cateID == -1) {
				break;
			}
			System.out.println("�������� �����ϼ���");
			im.itemPrint(cateID);
			int itemID = sc.nextInt();
			im.addCart(id, cateID, itemID);
			System.out.println("��ٱ��Ͽ� �������� �����ϴ�");
		}
	}
	
}
