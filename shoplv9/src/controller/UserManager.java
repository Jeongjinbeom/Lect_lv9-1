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
	
	public void join() {
		System.out.println("가입 할 id 를 입력하세요.");
		String id = sc.next();
		User temp = new User(id, 1000);
		userList.add(temp);
		System.out.println("가입성공!" + temp.getId() + "님 가입을 축하합니다.");
	}
	
	
	public void print() {
		for(int i=0; i<userList.size(); i++) {
			System.out.println("회원ID:"+userList.get(i).getId() + " 잔액 :"+userList.get(i).getMoney());
		}
	}
	public void remove() {
		System.out.println("탈퇴할 id 입력 : ");
		String id = sc.next();
		int ch = 0;
		for(int i=0; i<userList.size(); i++) {
			if(userList.get(i).getId().equals(id)) {
				this.userLog = i;
				ch = -1;
			}	
		}
		if(ch == -1) {
			userList.remove(userLog);
		}
		
		
	}
	
}
