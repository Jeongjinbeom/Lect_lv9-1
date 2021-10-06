package models;

import java.util.Scanner;

import controller.ItemManager;
import controller.UserManager;

public class Shop {
	Scanner scan = new Scanner(System.in);
	UserManager um = new UserManager();
	ItemManager im = new ItemManager();
	
	public void MainMenu() {
		
		while(true) {
			um.printID();
			
			System.out.println("[1.가입] [2.탈퇴] [3.로그인] [4.로그아웃]" + "\n[100.관리자] [0.종료] ");
			int sel = scan.nextInt();
			
			if(sel==1) {
				um.join();
			}
			else if(sel==2) {
				um.remove();
			}
			else if(sel==3) {
				if(um.logIn()) {
					loginMenu();
				}
			}
			else if(sel==4) {
				um.logOut();
			}
			else if(sel==100) {
				ManagerMenu();
			}
			else if(sel==0) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
	
	void loginMenu() {
		
		while(true) {
			
			System.out.println("[1.쇼핑] [2.장바구니목록] [0.뒤로가기]");
			int sel = scan.nextInt();
			
			if(sel==1) {
				
				while(true) {
					String usID = um.userList.get(um.log).id;
					System.out.println("카테고리를 선택하세요. [종료:-1]");
					im.printCategory();
					int caID = scan.nextInt();
					if(caID == -1) {
						break;
					}
					System.out.println("아이템을 선택하세요.");
					im.printItem(caID);
					int itemID = scan.nextInt();
					im.addCart(usID, caID, itemID);
					System.out.println("아이템이 장바구니에 담겼습니다.");
				}
			}
			else if(sel==2) {
				CartMenu();
			}
			else if(sel==0) {
				break;
			}
		}
	}
	
	void CartMenu() {
		
		while(true) {
			System.out.println("[1.내 장바구니] 2.[삭제] 3.[구입] 0.[뒤로가기]");
			int sel = scan.nextInt();
			
			String id = um.userList.get(um.log).id;
			int mo = um.userList.get(um.log).money;
			User u = new User(id, mo);
			
			if(sel==1) {
				im.printJang(u);
			}
			else if(sel==2) {
				im.printJang(u);
				im.removeCart(u);
			}
			else if(sel==3) {
				im.printJang(u);
				im.buyItem(u);
			}
			else if(sel==0) {
				break;
			}
		}
	}
	
	void ManagerMenu() {
		
		while(true) {
			System.out.println("[1.아이템관리] [2.카테고리관리] [3.장바구니관리] [4.유저관리] [0.뒤로가기] ");
			int sel = scan.nextInt();
			
			if(sel==1) {
				itemMenu();
			}
			else if(sel==2) {
				cateMenu();
			}
			else if(sel==3) {
				
			}
			else if(sel==4) {
				userMenu();
			}
			else if(sel==0) {
				break;
			}
		}
	}
	
	void itemMenu() {
		
		while(true) {
			System.out.println("[1.전체아이템] [2.추가] [3.삭제] [0.뒤로가기]");
			int sel = scan.nextInt();
			
			if(sel==1) {
				im.printItem();
			}
			else if(sel==2) {
				im.addItem();
			}
			else if(sel==3) {
				im.removeItem();
			}
			else if(sel==0) {
				break;
			}
		}
	}
	
	void cateMenu() {
		
		while(true) {
			System.out.println("[1.전체카테고리] [2.추가] [3.삭제] [0.뒤로가기]");
			int sel = scan.nextInt();
			
			if(sel==1) {
				im.printCategory();
			}
			else if(sel==2) {
				im.addCategory();
			}
			else if(sel==3) {
				im.removeCategory();
			}
			else if(sel==0) {
				break;
			}
		}
	}
	
	void userMenu() {
		
		while(true) {
			System.out.println("[1.전체유저] [2.추가] [3.삭제] [0.뒤로가기]");
			int sel = scan.nextInt();
			
			if(sel==1) {
				um.print();
			}
			else if(sel==2) {
				um.join();
			}
			else if(sel==3) {
				um.remove();
			}
			else if(sel==0) {
				break;
			}
		}
	}
}
