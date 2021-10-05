package models;

import java.util.ArrayList;
import java.util.Random;

import controller.UserManager;

public class User {
	Random rn = new Random();
	private int code;	// 1000~ 9999 Áßº¹X ·£´ý
	private String id;
	private String pw;
	private String name;
	private int money;
	
	UserManager user = UserManager.instance;
	//getter
	private ArrayList<Account> accs = new ArrayList<Account>();
	
	public User(int code, String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.code = code;
	}
	public int getCode() {
		return this.code;
	}
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
	public String getName() {
		return this.name;
	}
	public Account getAcc(int index) {
		return this.accs.get(index);
	}
	public int getAccsSize() {
		return this.accs.size();
	}
	public void addAcc(Account e) {
		this.accs.add(e);
	}
	public void removeAcc(Account e) {
		this.accs.remove(e);
	}
	
	public String toString() {
		String str = "";
		str += this.code + " ";
		str += this.id + "/";
		str += this.pw + " : ";
		str += this.name;
		str += "(" + this.accs.size()+")";
		return str;
	}
	
}
