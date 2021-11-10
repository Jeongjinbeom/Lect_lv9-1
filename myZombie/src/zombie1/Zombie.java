package zombie1;

public class Zombie extends Unit{

	public Zombie(String name, int hp, int hit, int def, int move) {
		
		super(name, hp, hit, def, move);
		
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
