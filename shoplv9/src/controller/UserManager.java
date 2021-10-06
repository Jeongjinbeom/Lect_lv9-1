package controller;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import models.User;

public class UserManager {
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);
	public static UserManager instance = new UserManager();
	public Vector<User> userList = new Vector<User>();
	private int userLog = -1; 
	
		
	public int getUserLog() {
		return userLog;
	}
	public void setUserLog(int userLog) {
		this.userLog = userLog;
	}
	
	public boolean login() {
		int ch = -1;
		System.out.println("로그인 할 아이디 입력 : ");
		String id = sc.next();
		for(int i = 0; i<this.userList.size(); i++) {
			if(id.equals(userList.get(i).getId())) {
				ch = i;
				break;
			}
		}
		if(ch == -1) {
			System.out.println("아이디를 확인해주세요");
			return false;
		}else {
			System.out.println(id+"님 로그인 되었습니다");
			this.userLog = ch;
			return true;
		}
	}
	
	public void logout() {
		if(this.userLog != -1) {
			System.out.println(this.userList.get(userLog).getId()+"님 로그아웃 되었습니다");
			this.userLog = -1;
		}else {
			System.out.println("로그인 후 이용해주세요.");
			return;
		}
	}
	
	public void join() {
		if(this.userLog == -1) {
			int ch = -1;
			System.out.println("가입 할 id 를 입력하세요.");
			String id = sc.next();
			for(int i=0; i<this.userList.size(); i++) {
				if(id.equals(userList.get(i).getId())){
					ch = i;
					break;
				}
			}
			if(ch == -1) {
				User temp = new User(id, 1000);
				userList.add(temp);
				System.out.println("가입성공!" + temp.getId() + "님 가입을 축하합니다.");		
			}else {
				System.out.println("아이디가 중복됩니다 가입불가");
				return;
			}
		}else {
			System.out.println("로그아웃 후 가입하세요.");
		}
		
	}
	
	
	public void print() {
		for(int i=0; i<userList.size(); i++) {
			System.out.println("회원ID:"+userList.get(i).getId() + " 잔액 :"+userList.get(i).getMoney());
		}
	}
	public void remove() {
		System.out.println("탈퇴할 id 입력 : ");
		String id = sc.next();
		
		
	}
	
}
