package app.labs.project.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerRepository implements IPlayerRepository {

	
	@Autowired
	PlayerVO player;
	
	@Override
	public void click() {
		int money = player.getPlayerMoney();
		int power = player.getPlayerClickPower();
		
		money += power;
		
		player.setPlayerMoney(money);
	}

	@Override
	public void levelUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean buyCar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buyHouse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buyClothes() {
		// TODO Auto-generated method stub
		return false;
	}

}
