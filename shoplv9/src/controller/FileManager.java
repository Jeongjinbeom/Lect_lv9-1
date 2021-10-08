package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {
	public static FileManager instance = new FileManager();
	private UserManager um = UserManager.instance;
	private ItemManager im = ItemManager.instance;


	private String userListFileName = "userList.txt";
	private String itemListFileName = "itemList.txt";
	private String jangListFileName = "jangList.txt";
	
	private File file = null;
	private FileWriter fw = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	

	public void sava() {
		String data = "";
		//userList
		for(int i=0; i<um.getUserListSize(); i++) {
			data += um.getUser(i).getId() + "/";
			data += um.getUser(i).getMoney() + "\n";
		}
		try {
			file = new File(userListFileName);
			fw = new FileWriter(file);
			fw.write(data);
			fw.close();
			System.out.println("저장 완료");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("저장 실패");
		}
		// itemList
		data = "";
		for(int i=0; i<im.getItemListSize(); i++) {
			data += im.getItem(i).getName() +"/";
			data += im.getItem(i).getPrice()+"/";
			data += im.getItem(i).getCategory() +"\n";
		}
		try {
			file = new File(itemListFileName);
			fw = new FileWriter(file);
			fw.write(data);
			fw.close();
			System.out.println("저장완료");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("저장실패");
		}
		// jangList
		data = "";
		for(int i=0; i<im.getJangListSize(); i++) {
			data += im.getCart(i).getUserID()+"/";
			data += im.getCart(i).getItemName()+"\n";
		}
		try {
			file = new File(jangListFileName);
			fw = new FileWriter(file);
			fw.write(data);
			fw.close();
			System.out.println("저장완료");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("저장실패");
		}
	}
	
	public void load() {
		
	}
	
}
