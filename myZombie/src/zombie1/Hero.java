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
			System.out.println("������ ���ż� ü���� ȸ�� �Ǿ����ϴ�.");
			this.setHp(unit.getHp() + 100);
			System.out.println(unit.getName() + "�� ü�� : " + unit.getHp());
			this.cnt--;
		} else {
			System.out.println("������ ��� �����߽��ϴ�.");
		}
	}

	@Override
	public void damage(Unit target) {
		int damage = this.getHit() - target.getDef();
		System.out.println(getName() + "�� ����");
		System.out.println(damage + "�� �����");
		target.setHp(target.getHp() - damage);
		System.out.println(target.getName() + "�� ���� ü�� : " + target.getHp());

	}

}
