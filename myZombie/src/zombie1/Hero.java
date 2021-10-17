package zombie1;

interface hpDrink {

}

public class Hero extends Unit implements hpDrink {
	private int cnt = 4;

	public int getCnt() {
		return cnt;
	}

	public Hero(String name, int hp, int hit, int def, int move) {
		super(name, hp, hit, def, move);
		super.unitPrint();
	}

	public void hpDrink(hpDrink hpdrink) {
		Unit unit = (Unit) hpdrink;
		if (this.cnt > 0) {
			System.out.println("물약을 마셔서 체력이 회복 되었습니다.");
			this.setHp(unit.getHp() + 100);
			System.out.println(unit.getName() + "의 체력 : " + unit.getHp());
			this.cnt--;
		} else {
			System.out.println("물약을 모두 소진했습니다.");
		}
	}

	@Override
	public void damage(Unit target) {
		int damage = this.getHit() - target.getDef();
		System.out.println(getName() + "의 공격");
		System.out.println(damage + "의 대미지");
		target.setHp(target.getHp() - damage);
		System.out.println(target.getName() + "의 남은 체력 : " + target.getHp());

	}

}
