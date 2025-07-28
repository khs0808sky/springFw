package app.labs.project.player;

public class Player {
	private int playerMoney = 0;
    private int playerLevel = 1;
    private int playerClickPower = 1;

    public void click() {
    	playerMoney += playerClickPower;
    }

    public void levelUp() {
        
    }
    
    public boolean buyCar() {
    	return false;
    }
    
    public boolean buyHouse() {
    	return false;
    }
    
    public boolean buyClothes() {
    	return false;
    }

    // Getter
    public int getMoney() {
        return playerMoney;
    }

    public int getLevel() {
        return playerLevel;
    }

    public int getClickPower() {
        return playerClickPower;
    }
}
