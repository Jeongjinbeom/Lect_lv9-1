package models;

import java.util.Scanner;

import controller.UserManager;

public class Shop {
	Scanner sc = new Scanner(System.in);
	public static Shop instance = new Shop();
	
	UserManager um = new UserManager();
	
	public void run() {
		mainRun();
		loginRun();
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
				
			}else if(sel == 4) {
				
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
		// TODO Auto-generated method stub
		
	}

	private void shopMenu() {
		// TODO Auto-generated method stub
		
	}
	
}
