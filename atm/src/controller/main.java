package controller;

import models.Bank;
import models.BankManager;

public class main {

	public static void main(String[] args) {

		// ���� �귣�带 �����ϰ�,
		Bank.instance.setBrand("Green");
		// ���� �ý����� run() �ϵ��� ȣ��
		BankManager.instance.run();
	}

}
