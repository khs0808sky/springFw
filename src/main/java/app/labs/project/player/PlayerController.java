package app.labs.project.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerController {
	
	@Autowired
	private IPlayerService playerService;
	
    public void click() {
        playerService.click();
    }

    public void levelUp() {
        playerService.levelUp();
    }
    
    public boolean buyCar(Car car) {
    	return playerService.buyCar(car);
    }
    
    public boolean buyHouse(House house) {
    	return playerService.buyHouse(house);
    }
    
    public boolean buyClothes(Clothes clothes) {
    	return playerService.buyClothes(clothes);
    }
}
