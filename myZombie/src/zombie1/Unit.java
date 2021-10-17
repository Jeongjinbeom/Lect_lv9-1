package zombie1;

interface Damage {
	public void damage(Unit target);
}

//�߻�Ŭ���� ����
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
		System.out.println("[�̸�] : " + name + " [ü��] : " + hp + "[���ݷ�] : " + hit + "[��ġ] : " + move + "[����] : " + def);
	}

	public void damage(Unit target) {
		int damage = this.hit - target.def;
		System.out.println(name + "�� ����");
		System.out.println(damage + "�� �����");
		target.setHp(target.getHp() - damage);
		System.out.println(target.name + "�� ���� ü�� : " + target.hp);

	}

}
