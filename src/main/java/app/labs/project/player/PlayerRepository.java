package app.labs.project.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerRepository implements IPlayerRepository {
	@Autowired
	PlayerVO player;	
	@Autowired
	Car car;
	@Autowired
	House house;
	@Autowired
	Clothes clothes;
	
	@Override
	public void click() {
		int money = player.getPlayerMoney();
		
		int basePower = player.getPlayerLevel();
		
		int bonusMultiplier = car.getBonus() * house.getBonus() * clothes.getBonus();
		int bonusDivisor = 100 * 100 * 100;  
		
		double total = ((double) basePower * bonusMultiplier) / bonusDivisor;
		int totalPower = (int) Math.ceil(total); // 소수점 올림
		
		player.setPlayerClickPower(totalPower);
		
		money += player.getPlayerClickPower();
	    player.setPlayerMoney(money);
	}	

	@Override
	public void levelUp() {
		int currentLevel = player.getPlayerLevel();
	    int currentGold = player.getPlayerMoney();
	    
	    int levelUpCost = currentLevel * 10;
	    
	    if (currentGold >= levelUpCost) {
	        player.setPlayerMoney(currentGold - levelUpCost);
	        player.setPlayerLevel(currentLevel + 1);
	        System.out.println("레벨업 성공! 현재 레벨: " + player.getPlayerLevel() +
                    ", 남은 골드: " + player.getPlayerMoney());
	    } else {
	    	System.out.println("레벨업 실패: 골드 부족");
	    }
	}

	@Override
	public boolean buyCar() {
		return false;
	}

	@Override
	public boolean buyHouse() {
		return false;
	}

	@Override
	public boolean buyClothes() {
		return false;
	}

}
