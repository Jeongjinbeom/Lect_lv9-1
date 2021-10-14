package zombie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);

	private Game() {
	}

	private static Game instance = new Game();

	public static Game getinstance() {
		return instance;
	}

	private Hero p;
	private ArrayList<Unit> enemy = new ArrayList<>();

	private void init() {
		p = new Hero("���", 100, 5, 1, 1);
		enemy.add(new Zombie("�׳�����", 25, 5, 1, 3));
		enemy.add(new Zombie("��������", 45, 10, 2, 6));
		enemy.add(new Zombie("��������", 65, 15, 3, 9));
		enemy.add(new ZombieKing("�����", 100, 20, 4, 12, 50));
	}

	private int chk() {
		for (int i = 0; i < enemy.size(); i++) {
			if (p.getpos() == enemy.get(i).getpos()) {
				System.out.println("���� ��Ÿ����!!!");
				return i;
			}
		}
		return -1;
	}

	private int die(Unit a) {
		if (p.gethp() <= 0) {
			return 1;
		} else if (a.gethp() <= 0) {
			return 2;
		} else {
			return 0;
		}
	}

	private boolean fight(Unit enemy) {
		while (true) {
			p.print();
			System.out.println("===== VS =====");
			enemy.print();
			System.out.println("--------------");
			System.out.println("[������ �ұ�? ]");
			System.out.println("1.����   2.����(" + p.getcnt() + "�� ����)");
			int sel = scan.nextInt();
			if (sel == 1) {
				p.attack(enemy);
			} else if (sel == 2) {
				p.drink();
			}
			if (die(enemy) != 0) {
				break;
			}
			System.out.println();
			enemy.attack(p);
			if (die(enemy) != 0) {
				break;
			}
			System.out.println();
		}
		if (die(enemy) == 1) {
			System.out.println("����ߴ�");
			return false;
		} else {
			System.out.println("�¸��ߴ�!");
			return true;
		}
	}

	private void map(int a) {
		System.out.println("[ ���� �� : " + p.getpos() + " ]");
		System.out.println("[1] : �ö󰣴�");
		if (a == 1) {
			System.out.println("[2] : ü���� ȸ���Ѵ�.");
			System.out.println("[3] : ���⸦ ��ȭ�Ѵ�.");
		}
	}

	public void run() {
		init();
		int act = 1;
		while (true) {
			if (p.getpos() >= 12) {
				System.out.println("������ �����ߴ�!!");
				break;
			}
			map(act);
			int sel = scan.nextInt();
			if (sel == 1) {
				p.setpos(p.getpos() + 1);
				int chk = chk();
				if (chk != -1) {
					boolean a = fight(enemy.get(chk));
					if (a == false) {
						break;
					}
				} else {
					System.out.println("�ƹ��ϵ� �Ͼ�� �ʾҴ�..");
				}
				act = 1;
			} else if (sel == 2 && act == 1) {
				int rnum = ran.nextInt(40) + 20;
				p.sethp(p.gethp() + rnum);
				System.out.println("ü���� " + rnum + "��ŭ ȸ���ߴ�!");
				act = 2;
			} else if (sel == 3 && act == 1) {
				int rnum = ran.nextInt(2) + 1;
				if (rnum == 1) {
					rnum = ran.nextInt(3) + 1;
					p.setatt(p.getatt() + rnum);
					System.out.println("���ݷ��� " + rnum + "��ŭ �����ߴ�!");
				} else if (rnum == 2) {
					rnum = ran.nextInt(3) + 1;
					p.setdef(p.getdef() + rnum);
					System.out.println("������ " + rnum + "��ŭ �����ߴ�!");
				}
				act = 2;
			}
		}
	}

}
