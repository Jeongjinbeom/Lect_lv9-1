package controller;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import models.User;

public class UserManager {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	public Vector<User> userList = new Vector<User>();
	public int log;
	
	public UserManager(){
		inti();
	}
	
	void inti() {
		for(int i=0; i<10; i++) {
			String[] a = { "김", "박", "이", "최", "정", "오" };
			String[] b = { "철", "병", "만", "여", "아", "영" };
			String[] c = { "수", "욱", "수", "정", "름", "희" };
			
			int r = ran.nextInt(a.length);
			String name = a[r];
			r = ran.nextInt(b.length);
			name += b[r];
			r= ran.nextInt(c.length); 
			name += c[r];
			
			r = ran.nextInt(10000);
			int money = r;
			User temp = new User(name, money);
			userList.add(temp);
		}
	}
	
	public void join() {
		int check = -1;
		System.out.println("아이디를 입력하세요.");
		String id = scan.next();
		
		for(int i=0; i<userList.size(); i++) {
			if(id.equals(userList.get(i).id)) {
				check = i;
				break;
			}
		}
		
		if(check == -1) {
			System.out.println(id+"님 가입을 환영합니다.");
			User temp = new User(id, 0);
			userList.add(temp);
		}
		else {
			System.out.println("중복되는 아이디입니다.");
			return;
		}
	}
	
	public void remove() {
		int check = -1;
		System.out.println("아이디를 입력하세요.");
		String id = scan.next();
		for(int i=0; i<userList.size(); i++) {
			if(id.equals(userList.get(i).id)) {
				check = i;
				break;
			}
		}
		if(check == -1) {
			System.out.println("존재하지않는 아이디입니다.");
		}
		else {
			System.out.println(""+id+"님 탈퇴되었습니다.");
			userList.remove(check);
		}
	}
	
	public boolean logIn() {
		int check = -1;
		System.out.println("아이디를 입력하세요.");
		String id = scan.next();
		for(int i=0; i<userList.size(); i++) {
			if(id.equals(userList.get(i).id)) {
				check = i;
				break;
			}
		}
		if(check == -1) {
			System.out.println("아이디를 확인해주세요.");
			return false;
		}
		else {
			System.out.println(id+"님 환영합니다.");
			log = check;
			return true;
		}
	}
	
	public void logOut() {
		
		if(log != -1) {
			System.out.println(userList.get(log).id+"님 로그아웃되었습니다.");
			log = -1;	
		}
		else {
			System.out.println("로그인시에만 가능합니다.");
			return;
		}
	}
	
	public void print() {
		for(int i=0; i<userList.size(); i++) {
			System.out.print("["+i+"]");
			userList.get(i).print();
		}
	}
	
	public void printID() {
		for(int i=0; i<userList.size(); i++) {
			System.out.println("회원ID:"+userList.get(i).getId() + " 잔액 :"+userList.get(i).getMoney());
		}
	}
	
	
	
}