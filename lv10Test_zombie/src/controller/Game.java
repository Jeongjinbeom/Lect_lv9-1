package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.Unit;
import models.Zombie;
import models.ZombieKing;

public class Game {
	private static Game instance = new Game();
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	private ArrayList<Unit> zombie = new ArrayList<>();
	
	private Hero hero;
	
	public static Game getInstance() {
		return instance;
	}
	
	private void newUnit() {
		this.hero = new Hero("소환사", 100, 5, 3, 1);
		this.zombie.add(new Zombie("애기좀비",30,4,0,3));
		this.zombie.add(new Zombie("성인좀비", 60, 4, 3, 6));
		this.zombie.add(new Zombie("군인좀비",120,5,1,9));
		this.zombie.add(new Zombie("방어형좀비",100,3,5,12));
		this.zombie.add(new ZombieKing("좀비킹",300,7,5,16));
	}
	
	private int die(Unit u) {
		if(this.hero.getHp() <= 0) {
			return 1;
		}else if(u.getHp()<= 0) {
			return 2;
		}else {
			return 0;
		}
	}
	
	private void printMove(int a) {
		System.out.println("현재 위치 "+this.hero.getMove());
		System.out.println("1 올라가기");
		if(a == 1) {
			System.out.println("2 체력 회복하기");
		}else if(a == 2) {
			System.out.println("3 공격력 증가");
		}
	}
	private int check() {
		for(int i=0; i< this.zombie.size(); i++) {
			if(this.hero.getMove() == this.zombie.get(i).getMove()) {
				System.out.println("좀비를 만났다.");
				return i;
			}
		}
		return -1;
	}
	public void run() {
		newUnit();
		int a = 1;
		while (true) {
			if(this.hero.getMove() >= 16) {
				System.out.println("GameClear~");
				break;
			}
			printMove(a);
			System.out.println("메뉴 선택 :");
			int sel = sc.nextInt();
			if(sel ==1) {
				this.hero.setMove(this.hero.getMove()+1);
				int check = check();
				if(check != -1) {
					boolean boo = fight(this.zombie.get(check));
					if(boo == false) {
						break;
					}
				}
			}else if(sel ==2 && a== 1) {
				
			}
		}
	}

	private boolean fight(Unit unit) {
		while(true) {
			this.hero.unitPrint();
			System.out.println("============== VS ===========");
			unit.unitPrint();
			System.out.println("1) 공격 2)포션먹기("+this.hero.getCnt()+"개 남음");
			System.out.println("매뉴 선택 : ");
			int sel = sc.nextInt();
			if(sel == 1) {
			this.hero.hitDamage(unit);
			}else if(sel ==2) {
				this.hero.hpDrink(hero);
			}
			if(die(unit) != 0) {
				break;
			}
			
		}
		
		
		
		if(die(unit) == 1) {
			System.out.println("플레이어 사망.");
			return false;	
		}else {
			System.out.println("승리했다.");
			return true;
		}
	}
	
}
