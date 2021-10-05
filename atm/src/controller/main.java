package controller;

import models.Bank;
import models.BankManager;

public class main {

	public static void main(String[] args) {

		// 은행 브랜드를 지정하고,
		Bank.instance.setBrand("Green");
		// 은행 시스템이 run() 하도록 호출
		BankManager.instance.run();
	}

}
