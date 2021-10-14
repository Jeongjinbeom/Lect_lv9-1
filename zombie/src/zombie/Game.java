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
		p = new Hero("용사", 100, 5, 1, 1);
		enemy.add(new Zombie("그냥좀비", 25, 5, 1, 3));
		enemy.add(new Zombie("힘쌘좀비", 45, 10, 2, 6));
		enemy.add(new Zombie("정예좀비", 65, 15, 3, 9));
		enemy.add(new ZombieKing("좀비왕", 100, 20, 4, 12, 50));
	}

	private int chk() {
		for (int i = 0; i < enemy.size(); i++) {
			if (p.getpos() == enemy.get(i).getpos()) {
				System.out.println("좀비가 나타났다!!!");
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
			System.out.println("[무엇을 할까? ]");
			System.out.println("1.공격   2.물약(" + p.getcnt() + "개 남음)");
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
			System.out.println("사망했다");
			return false;
		} else {
			System.out.println("승리했다!");
			return true;
		}
	}

	private void map(int a) {
		System.out.println("[ 현재 층 : " + p.getpos() + " ]");
		System.out.println("[1] : 올라간다");
		if (a == 1) {
			System.out.println("[2] : 체력을 회복한다.");
			System.out.println("[3] : 무기를 강화한다.");
		}
	}

	public void run() {
		init();
		int act = 1;
		while (true) {
			if (p.getpos() >= 12) {
				System.out.println("생존에 성공했다!!");
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
					System.out.println("아무일도 일어나지 않았다..");
				}
				act = 1;
			} else if (sel == 2 && act == 1) {
				int rnum = ran.nextInt(40) + 20;
				p.sethp(p.gethp() + rnum);
				System.out.println("체력을 " + rnum + "만큼 회복했다!");
				act = 2;
			} else if (sel == 3 && act == 1) {
				int rnum = ran.nextInt(2) + 1;
				if (rnum == 1) {
					rnum = ran.nextInt(3) + 1;
					p.setatt(p.getatt() + rnum);
					System.out.println("공격력이 " + rnum + "만큼 증가했다!");
				} else if (rnum == 2) {
					rnum = ran.nextInt(3) + 1;
					p.setdef(p.getdef() + rnum);
					System.out.println("방어력이 " + rnum + "만큼 증가했다!");
				}
				act = 2;
			}
		}
	}

}
