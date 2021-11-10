package zombie1;

public class Zombie extends Unit{

	public Zombie(String name, int hp, int hit, int def, int move) {
		
		super(name, hp, hit, def, move);
		
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
