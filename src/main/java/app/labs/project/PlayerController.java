package app.labs.project;

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
    
    public boolean buyCar() {
    	return playerService.buyCar();
    }
    
    public boolean buyHouse() {
    	return playerService.buyHouse();
    }
    
    public boolean buyClothes() {
    	return playerService.buyClothes();
    }
}
