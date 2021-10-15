package zombie1;




public class Hero extends Unit{
	
	private int cnt = 5;
	
	public Hero(String name, int hp, int hit, int def, int move) {
		super(name, hp, hit, def, move);
		super.unitPrint();
	}

	public int getCnt() {
		return cnt;
	}
	
	public void hpDrink() {
		if(this.cnt>0) {
			System.out.println("������ ���ż� ü���� 100�� �Ǿ����ϴ�.");
			this.setHp(this.getHp() + 100);
			System.out.println(this.getName()+"�� ü�� : "+this.getHp());
			cnt--;
		}else {
			System.out.println("������ ��� �����߽��ϴ�.");
		}
	}

	@Override
	public void damage(Unit target) {
		// TODO Auto-generated method stub
		
	}
	
}
