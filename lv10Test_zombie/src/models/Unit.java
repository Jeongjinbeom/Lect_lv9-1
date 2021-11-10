package models;

interface hitDamage{
	public void hitDamage(Unit target);
}

public abstract class Unit implements hitDamage{
	private String name;
	private int hp;
	private int hit;
	private int def;
	private int move;
	
	public Unit(String name, int hp, int hit, int def, int move) {
		this.name = name;
		this.hp = hp;
		this.hit = hit;
		this.def = def;
		this.move = move;
	}
	public void hitDamage(Unit target) {
		int hit = this.hit - target.def;
		System.out.println(name + "�� ����");
		System.out.println(hit +"�� ������");
		target.setHp(target.getHp() - hit);
		System.out.println(target.name +"�� ü�� : "+target.hp);
	}
	
	public void unitPrint() {
		System.out.printf("�̸� : %s, ü�� : %d, ���ݷ� : %d, ���� : %d, ��ġ : %d",this.name, this.hp, this.hit, this.def, this.move);
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

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
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
	
}
