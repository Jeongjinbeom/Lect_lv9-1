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
			System.out.println(" 1)가입\n 2)탈퇴\n 3)로그인\n 4)로그아웃\n 100)관리자모드\n 0)종료");
			System.out.println("매뉴선택 : ");
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
				System.out.println("잘못된 매뉴선택입니다.");
			}
		
		}
	}
	
	public void loginRun() {
		while (true) {
			System.out.println(" 1.쇼핑\n2.장바구니목록\n0.뒤로가기\n");
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
			System.out.println("매뉴 선택 : " +"종료 : -1");
			im.printCate();
			int cateID = sc.nextInt();
			if(cateID == -1) {
				break;
			}
			System.out.println("아이템을 선택하세요");
			im.itemPrint(cateID);
			int itemID = sc.nextInt();
			im.addCart(id, cateID, itemID);
			System.out.println("장바구니에 아이템이 담겼습니다");
		}
	}
	
}
