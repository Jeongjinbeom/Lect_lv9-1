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
		while (true) {
			um.print();
			System.out.println();
			System.out.println("=======SuperMaket======");
			System.out.println(" 1)����\n 2)Ż��\n 3)�α���\n 4)�α׾ƿ�\n 100)�����ڸ��\n 0)����");
			System.out.println("�Ŵ����� : ");
			int sel = sc.nextInt();
			if (sel == 1) {
				um.join();
			} else if (sel == 2) {
				um.remove();
			} else if (sel == 3) {
				if (um.login()) {
					loginRun();
				}
			} else if (sel == 4) {
				um.logout();
			} else if (sel == 100) {
				managerMenu();
			} else if (sel == 0) {
				break;
			} else {
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
		while (true) {
			System.out.println(" 1.��ٱ���\n 2.����\n 3.����\n 0.�ڷΰ���");
			int sel = sc.nextInt();

			String ID = um.userList.get(um.getUserLog()).getId();
			int money = um.userList.get(um.getUserLog()).getMoney();
			User u = new User(ID, money);

			if (sel == 1) {
				im.printJang(u);
			} else if (sel == 2) {
				im.printJang(u);
				im.removeCart(u);
			} else if (sel == 3) {
				im.printJang(u);
				im.getItem(u);
			} else if (sel == 0) {
				break;
			} else {
				System.out.println("�߸��� �Ŵ������Դϴ�.");
			}
		}
	}

	private void shopMenu() {

		while (true) {
			String id = um.userList.get(um.getUserLog()).getId();
			System.out.println("�Ŵ� ���� : " + "���� : -1");
			im.printCate();
			int cateID = sc.nextInt();
			if (cateID == -1) {
				break;
			}
			System.out.println("�������� �����ϼ���");
			im.itemPrint(cateID);
			int itemID = sc.nextInt();
			im.addCart(id, cateID, itemID);
			System.out.println("��ٱ��Ͽ� �������� �����ϴ�");
		}
	}

	public void managerMenu() {

		while (true) {
			System.out.println(" 1.�����۰���\n 2.ī�װ�����\n 3.��������\n 0.�ڷΰ���");
			System.out.println("�Ŵ��Է� : ");
			int sel = sc.nextInt();
			if (sel == 1) {
				itemMana();
			} else if (sel == 2) {
				categoryMenu();
			} else if (sel == 3) {
				userMenu();
			} else if (sel == 0) {
				break;
			} else {
				System.out.println("�߸��� �����Դϴ�.");
			}
		}
	}

	public void userMenu() {
		while (true) {
			System.out.println(" 1.��ü����\n 2.�����߰�\n 3.��������\n 0.�ڷΰ���\n");
			System.out.println("�Ŵ����� : ");
			int sel = sc.nextInt();

			if (sel == 1) {
				um.print();
			} else if (sel == 2) {
				um.join();
			} else if (sel == 3) {
				um.remove();
			} else if (sel == 0) {
				break;
			}
		}
	}

	private void categoryMenu() {
		while (true) {
			System.out.println(" 1.��üī�װ�\n 2.ī�װ��߰�\n 3.ī�װ�����\n 0.�ڷΰ���");
			int sel = sc.nextInt();
			System.out.println("�Ŵ� ���� : ");
			if (sel == 1) {
				im.printCate();
			} else if (sel == 2) {
				im.addCategory();
				;
			} else if (sel == 3) {
				im.removeCategory();
			} else if (sel == 0) {
				break;
			} else {
				System.out.println("�߸��� �Ŵ������Դϴ�.");
			}
		}

	}

	public void itemMana() {

		while (true) {
			System.out.println(" 1.��ü������\n 2.�������߰�\n 3.�����ۻ���\n 0.�ڷΰ���");
			System.out.println("�Ŵ� ���� : ");
			int sel = sc.nextInt();
			if (sel == 1) {
				im.printItem();
			} else if (sel == 2) {
				im.addItem();
			} else if (sel == 3) {
				im.removeItem();
			} else if (sel == 0) {
				break;
			} else {
				System.out.println("�߸��� �Ŵ� �����Դϴ�.");
			}
		}
	}

}
