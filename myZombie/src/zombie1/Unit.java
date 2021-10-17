package zombie1;

interface Damage {
	public void damage(Unit target);
}

//추상클래스 생성
abstract public class Unit implements Damage {

	private String name;
	private int hp;
	private int hit;
	private int def;
	private int move;

	public Unit(String name, int hp, int hit, int def, int move) {
		this.name = name;
		this.hp = hp;
		this.hit = hit;
		this.move = move;
		this.def = def;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public void unitPrint() {
		System.out.println("[이름] : " + name + " [체력] : " + hp + "[공격력] : " + hit + "[위치] : " + move + "[방어력] : " + def);
	}

	public void damage(Unit target) {
		int damage = this.hit - target.def;
		System.out.println(name + "의 공격");
		System.out.println(damage + "의 대미지");
		target.setHp(target.getHp() - damage);
		System.out.println(target.name + "의 남은 체력 : " + target.hp);

	}

}
