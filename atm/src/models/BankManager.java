package models;

import java.util.Scanner;

import controller.AccountManager;
import controller.FileManager;
import controller.UserManager;
import models.Bank;

public class BankManager {
public static Scanner sc = new Scanner(System.in);
	
	public static BankManager instance = new BankManager();
	
	private FileManager fm = FileManager.instance;
	private UserManager um = UserManager.instance;
	private AccountManager am = AccountManager.instance;
	
	// 기능 메소드 구현
	public void run() {
		fm.load();
		boolean isRun = true;
		while(isRun) {
			System.out.println(Bank.instance.getBrand()+ " ATM");
			
			printAllData();
			printMenu();
			isRun = selectMenu();
	
		}
		fm.save();
	}
	
	private void printAllData() {
		for(int i=0; i<um.getUsersSize(); i++) {
			System.out.println(um.getUser(i));
			
			for(int j=0; j<um.getUserAccSize(i); j++) {
				System.out.println(um.getUser(i).getAcc(j));
			}
		}
	}
	
	private void printMenu() {
		if(Bank.log == -1) {
			System.out.println(" 1.로그인\n 2.회원가입\n 3.회원탈퇴\n 4.종료 ");			
		}else {
			System.out.println(" 1입금\n 2.출금\n 3.조회\n 4.이체\n 5.계좌생성\n 6.계좌철회\n 7.로그아웃");
		}
		
	}

	private boolean selectMenu() {
		System.out.println("menu : ");
		String input = sc.next();
		
		try {
			int sel = Integer.parseInt(input);
			
			if(Bank.log == -1) {
				if(sel == 1) {
					login();
				}else if(sel == 2) {
					um.joinUser();
				}
				else if(sel == 3) {
					um.removeUser();
				}else if(sel == 4) {
					return false;
				}else {
					System.out.println("잘못된 선택입니다.");
				}
			}else {
				if(um.getUserAccSize(Bank.log) > 0) {
					if(sel == 1) {
						am.inputMoney(Bank.log);
					}else if(sel == 2) {
						am.outMoney(Bank.log);
					}else if(sel == 3) {
						am.printUserAccs(Bank.log);
					}else if(sel == 4) {
						am.moveMoney(Bank.log);
					}else if(sel == 6) {
						am.dropAccount(Bank.log);
					}
				}
				
				if(sel == 5) {
					am.createAcc(Bank.log);
				}if(sel == 7) {
					logout();
				}
				
			}
		}catch(Exception e) {
			
		}
		return true;
	}

	private void login() {
		System.out.println("id : ");
		String id = sc.next();
		System.out.println("pw : ");
		String pw = sc.next();
		
		for(int i=0; i<um.getUsersSize(); i++) {
			if(id.equals(um.getUser(i).getId())&& pw.equals(um.getUser(i).getPw())) {
				Bank.log = i;
			}
		}
		if(Bank.log != -1) {
			System.out.println("로그인 성공");
		}
	}
	private void logout() {
		Bank.log = -1;
	}

	
}
