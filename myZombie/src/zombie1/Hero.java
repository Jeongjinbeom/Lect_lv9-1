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
			System.out.println("물약을 마셔서 체력이 100이 되었습니다.");
			this.setHp(this.getHp() + 100);
			System.out.println(this.getName()+"의 체력 : "+this.getHp());
			cnt--;
		}else {
			System.out.println("물약을 모두 소진했습니다.");
		}
	}

	@Override
	public void damage(Unit target) {
		// TODO Auto-generated method stub
		
	}
	
}
