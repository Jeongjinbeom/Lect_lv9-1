package zombie1;

import java.util.ArrayList;
import java.util.Scanner;



class Game {
	private static Game instance = new Game();
	Scanner sc = new Scanner(System.in);
	public static Game getinstance() {
		return instance;
	}
	
	private ArrayList<Unit> zombie = new ArrayList<>();
	
	private Hero hero;
	
	private void init() {
		this.hero = new Hero("����", 100, 10, 3, 1);
		this.zombie.add(new Zombie("�Ʊ�����", 20, 3, 0, 3));
		this.zombie.add(new Zombie("��������", 50, 7, 3, 6));
		this.zombie.add(new Zombie("��������", 90, 10, 5, 9));
	}
	private int ch() {
		for(int i=0; i< this.zombie.size(); i++) {
			if(this.hero.getMove() == this.zombie.get(i).getMove()) {
				System.out.println("���� ��Ÿ����!");
				return i;
			}
		}
		return -1;
	}
	private int heroDie(Unit a) {
		if(this.hero.getHp() <= 0) {
			return 1;
		}else if(a.getHp() <= 0) {
			return 2;
		}else {
			return 0;
		}
	}
	private boolean fight(Unit zombie) {
		while(true) {
			this.hero.unitPrint();
			System.out.println("=========================== VS ============================");
			zombie.unitPrint();
			System.out.println("1) ���� 2)����("+ this.hero.getCnt()+"�� ����)");
			System.out.println("�����ϼ��� : ");
			int sel = sc.nextInt();
			if(sel == 1) {
				this.hero.damage(zombie);
			}else if(sel == 2) {
				this.hero.hpDrink();
			}else {
				System.out.println("�߸��� �����Դϴ�.");
			}
			if(heroDie(zombie) != 0) {
				break;
			}
			System.out.println();
			zombie.damage(this.hero);
			if(heroDie(zombie) != 0) {
				break;
			}
			System.out.println();
		}
		if(heroDie(zombie) == 1) {
			System.out.println("�׾���.");
			return false;
		}else {
			System.out.println("�̰��.");
			return true;
		}
	}
	private void printMove(int a) {
		System.out.println("���� ��ġ : "+ this.hero.getMove()+"��");
		System.out.println("1 : �ö󰡱�");
		if(a == 1) {
			System.out.println("2 : ���Ǹ��ñ�.");
		}
	}
	
	public void run() {
		init();
		
		while(true) {
			if(this.hero.getMove() >= 9) {
			System.out.println("���� ��� �����ƴ�!");	
			break;
			}
		}
	}

}
