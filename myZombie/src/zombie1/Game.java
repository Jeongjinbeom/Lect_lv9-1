package zombie1;

import java.util.ArrayList;



class Game {
	private static Game instance = new Game();
	
	public static Game getinstance() {
		return instance;
	}
	
	private ArrayList<Unit> zombie = new ArrayList<>();
	
	private Hero hero;
	
	private void init() {
		this.hero = new Hero("����", 100, 10, 3, 1);
		this.zombie.add(new Zombie("�Ʊ�����", 20, 3, 0, 3));
		this.zombie.add(new Zombie("��������", 50, 7, 3, 6));
		this.zombie.add(new Zombie("��������", 90, 10, 5, 9));
	}
	
	
	
	public void run() {
		init();
	}

}
