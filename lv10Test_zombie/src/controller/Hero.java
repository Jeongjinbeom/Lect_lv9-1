package controller;

import models.Unit;

interface hpDrink{
	
}

public class Hero extends Unit implements hpDrink{

	public Hero(String name, int hp, int hit, int def, int move) {
		super(name, hp, hit, def, move);
	}
	private int cnt = 3;
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public void hpDrink(hpDrink hpdrink) {
		Unit u = (Unit) hpdrink;
		if(this.cnt > 0) {
		
		}else {
			System.out.println("더이상 남은 물약이 없습니다.");
		}
	}
	@Override
	public void hitDamage(Unit target) {
		int hit = this.getHit() - target.getDef();
		System.out.println(getName() + "의 공격");
		System.out.println(hit +"의 데미지");
		target.setHp(target.getHp() - hit);
		System.out.println(target.getName() +"의 체력 : "+target.getHp());
	
	}
	

}
