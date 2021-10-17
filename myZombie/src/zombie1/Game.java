package zombie1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Game {
	private static Game instance = new Game();
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();

	public static Game getinstance() {
		return instance;
	}

	private ArrayList<Unit> zombie = new ArrayList<>();

	private Hero hero;

	private void init() {
		this.hero = new Hero("전사", 100, 10, 3, 1);
		this.zombie.add(new Zombie("아기좀비", 20, 3, 0, 3));
		this.zombie.add(new Zombie("힘쎈좀비", 50, 7, 3, 6));
		this.zombie.add(new Zombie("전사좀비", 90, 10, 5, 9));
		this.zombie.add(new Zombieking("좀비왕", 200, 20, 4, 12));
	}

	private int ch() {
		for (int i = 0; i < this.zombie.size(); i++) {
			if (this.hero.getMove() == this.zombie.get(i).getMove()) {
				System.out.println("좀비가 나타났다!");
				return i;
			}
		}
		return -1;
	}

	private int heroDie(Unit a) {
		if (this.hero.getHp() <= 0) {
			return 1;
		} else if (a.getHp() <= 0) {
			return 2;
		} else {
			return 0;
		}
	}

	private boolean fight(Unit zombie) {
		while (true) {
			this.hero.unitPrint();
			System.out.println("=========================== VS ============================");
			zombie.unitPrint();
			System.out.println("1) 공격 2)물약(" + this.hero.getCnt() + "개 보유)");
			System.out.println("선택하세요 : ");
			int sel = sc.nextInt();
			if (sel == 1) {
				this.hero.damage(zombie);
			} else if (sel == 2) {
				this.hero.hpDrink(this.hero);
			} else {
				System.out.println("잘못된 선택입니다.");
			}
			if (heroDie(zombie) != 0) {
				break;
			}
			System.out.println();
			zombie.damage(this.hero);
			if (heroDie(zombie) != 0) {
				break;
			}
			System.out.println();
		}
		if (heroDie(zombie) == 1) {
			System.out.println("죽었다.");
			return false;
		} else {
			System.out.println("이겼다.");
			return true;
		}
	}

	private void printMove(int a) {
		System.out.println("현재 위치 : " + this.hero.getMove() + "층");
		System.out.println("1 : 올라가기");
		if (a == 1) {
			System.out.println("2 : 체력 회복하기");
		}
	}

	public void run() {
		init();
		int a = 1;
		while (true) {
			if (this.hero.getMove() >= 12) {
				System.out.println("좀비를 모두 물리쳤다!");
				break;
			}
			printMove(a);
			System.out.println("매뉴 선택 : ");
			int sel = sc.nextInt();
			if (sel == 1) {
				this.hero.setMove(this.hero.getMove() + 1);
				int ch = ch();
				if (ch != -1) {
					boolean boo = fight(this.zombie.get(ch));
					if (boo == false) {
						break;
					}
				} else {
					System.out.println("좀비가 발견되지 않았다.");
				}
				a = 1;
			} else if (sel == 2 && a == 1) {
				int ranHp = ran.nextInt(30)+20;
				this.hero.setHp(this.hero.getHp()+ranHp);
				System.out.println("체력"+ranHp+"회복완료");
				a = 2;
			}
		}
	}
}
