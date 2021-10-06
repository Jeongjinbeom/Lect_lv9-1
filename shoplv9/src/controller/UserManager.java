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
		System.out.println("�α��� �� ���̵� �Է� : ");
		String id = sc.next();
		for(int i = 0; i<this.userList.size(); i++) {
			if(id.equals(userList.get(i).getId())) {
				ch = i;
				break;
			}
		}
		if(ch == -1) {
			System.out.println("���̵� Ȯ�����ּ���");
			return false;
		}else {
			System.out.println(id+"�� �α��� �Ǿ����ϴ�");
			this.userLog = ch;
			return true;
		}
	}
	
	public void logout() {
		if(this.userLog != -1) {
			System.out.println(this.userList.get(userLog).getId()+"�� �α׾ƿ� �Ǿ����ϴ�");
			this.userLog = -1;
		}else {
			System.out.println("�α��� �� �̿����ּ���.");
			return;
		}
	}
	
	public void join() {
		if(this.userLog == -1) {
			int ch = -1;
			System.out.println("���� �� id �� �Է��ϼ���.");
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
				System.out.println("���Լ���!" + temp.getId() + "�� ������ �����մϴ�.");		
			}else {
				System.out.println("���̵� �ߺ��˴ϴ� ���ԺҰ�");
				return;
			}
		}else {
			System.out.println("�α׾ƿ� �� �����ϼ���.");
		}
		
	}
	
	
	public void print() {
		for(int i=0; i<userList.size(); i++) {
			System.out.println("ȸ��ID:"+userList.get(i).getId() + " �ܾ� :"+userList.get(i).getMoney());
		}
	}
	public void remove() {
		System.out.println("Ż���� id �Է� : ");
		String id = sc.next();
		
		
	}
	
}
